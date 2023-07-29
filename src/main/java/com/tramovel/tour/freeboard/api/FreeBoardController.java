package com.tramovel.tour.freeboard.api;

import com.tramovel.tour.freeboard.dto.FreeBoardDetailDTO;
import com.tramovel.tour.freeboard.dto.FreeBoardListDTO;
import com.tramovel.tour.freeboard.dto.UploadRequestDTO;
import com.tramovel.tour.freeboard.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/freeBoard")
@RequiredArgsConstructor
public class FreeBoardController {

  private final FreeBoardService freeBoardService;
  @PostMapping
  public void upload(@RequestBody UploadRequestDTO requestDTO) {
    freeBoardService.upload(requestDTO);
  }

  @GetMapping("/{hotel}")
  public ResponseEntity<?> getFreeBoardList(@PathVariable("hotel") Long hotel) {
    log.info("Get freeList");
    FreeBoardListDTO freeBoardDTOS = freeBoardService.retrieve(hotel);
    System.out.println("freeBoardDTOS = " + freeBoardDTOS);
    return ResponseEntity.ok().body(freeBoardDTOS);
  }

  @GetMapping("/my/{nick}")
  public ResponseEntity<?> getMyFreeBoardList(@PathVariable("nick") String nick) {
    log.info("Get freeList");
    FreeBoardListDTO freeBoardDTOS = freeBoardService.myList(nick);
    System.out.println("freeBoardDTOS = " + freeBoardDTOS);
    return ResponseEntity.ok().body(freeBoardDTOS);
  }

  @GetMapping("/detail/{id}")
  public ResponseEntity<?> getFreeBoardDetail(@PathVariable("id") long id) {
    log.info("Get freeDetail");
    FreeBoardDetailDTO freeBoard = freeBoardService.getDetail(id);
    System.out.println("freeBoard = " + freeBoard);
    return  ResponseEntity.ok().body(freeBoard);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteBoard(@PathVariable("id") long id) {
    log.info("Delete freeBoard");
    try {
      freeBoardService.delete(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResponseEntity.ok().body("삭제가 완료되었습니다.");
  }
}
