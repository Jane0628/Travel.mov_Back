package com.tramovel.tour.freeboard.api;

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

  @GetMapping("/{nick}")
  public ResponseEntity<?> getFreeBoardList(@PathVariable("nick") String nick) {
    log.info("Get freeList");
    FreeBoardListDTO freeBoardDTOS = freeBoardService.retrieve(nick);
    System.out.println("freeBoardDTOS = " + freeBoardDTOS);
    return ResponseEntity.ok().body(freeBoardDTOS);
  }
}
