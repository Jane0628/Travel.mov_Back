package com.tramovel.tour.freeboard.service;

import com.tramovel.tour.freeboard.dto.FreeBoardDetailDTO;
import com.tramovel.tour.freeboard.dto.FreeBoardListDTO;
import com.tramovel.tour.freeboard.dto.UploadRequestDTO;
import com.tramovel.tour.freeboard.entity.FreeBoard;
import com.tramovel.tour.freeboard.repository.FreeBoardRepository;
import com.tramovel.tour.reservation.dto.ReservationDetailResponseDTO;
import com.tramovel.tour.reservation.dto.ReservationListResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
      .movie(requestDTO.getMovie())
      .star(requestDTO.getStar())
      .build();
    freeBoardRepository.save(freeBoard);

  }

  public FreeBoardListDTO retrieve(String movie) {
     List<FreeBoard> entityList = freeBoardRepository.findAllByMovie(movie);
    List<FreeBoardDetailDTO> dtoList = entityList.stream().map(FreeBoardDetailDTO::new)
      .collect(Collectors.toList());
    return FreeBoardListDTO.builder().freeBoards(dtoList).build();
  }

  public FreeBoardDetailDTO getDetail(long id) {
    FreeBoard freeBoard = freeBoardRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
    return FreeBoardDetailDTO.builder()
      .id(freeBoard.getId())
      .title(freeBoard.getTitle())
      .content(freeBoard.getContent())
      .movie(freeBoard.getMovie())
      .star(freeBoard.getStar())
      .userNick(freeBoard.getUserNick())
      .uploadDate(freeBoard.getUploadDate())
      .build();
  }

  public void delete(long id) {
    try {
      freeBoardRepository.deleteById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public FreeBoardListDTO myList(String nick) {
    List<FreeBoard> entityList = freeBoardRepository.findAllByNick(nick);
    List<FreeBoardDetailDTO> dtoList = entityList.stream().map(FreeBoardDetailDTO::new)
      .collect(Collectors.toList());
    return FreeBoardListDTO.builder().freeBoards(dtoList).build();
  }
}
