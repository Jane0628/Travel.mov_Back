package com.tramovel.tour.freeboard.service;

import com.tramovel.tour.freeboard.dto.UploadRequestDTO;
import com.tramovel.tour.freeboard.entity.FreeBoard;
import com.tramovel.tour.freeboard.repository.FreeBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FreeBoardService {
  private final FreeBoardRepository freeBoardRepository;
  public void upload(UploadRequestDTO requestDTO) {
    FreeBoard freeBoard = FreeBoard.builder()
      .content(requestDTO.getContent())
      .title(requestDTO.getTitle())
      .userNick(requestDTO.getUserNick())
      .build();
    freeBoardRepository.save(freeBoard);

  }
}
