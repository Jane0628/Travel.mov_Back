package com.tramovel.tour.freeboard.api;

import com.tramovel.tour.freeboard.dto.UploadRequestDTO;
import com.tramovel.tour.freeboard.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/freeBoard")
@RequiredArgsConstructor
public class FreeBoardController {

  private final FreeBoardService freeBoardService;
  @PostMapping
  public void upload(@RequestBody UploadRequestDTO requestDTO) {
    freeBoardService.upload(requestDTO);
  }
}
