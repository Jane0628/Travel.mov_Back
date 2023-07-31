package com.tramovel.tour.freeboard.service;

import com.tramovel.tour.freeboard.dto.FreeBoardDetailDTO;
import com.tramovel.tour.freeboard.dto.FreeBoardListDTO;
import com.tramovel.tour.freeboard.dto.UploadRequestDTO;
import com.tramovel.tour.freeboard.entity.FreeBoard;
import com.tramovel.tour.freeboard.repository.FreeBoardRepository;
import com.tramovel.tour.hotel.entity.Hotel;
import com.tramovel.tour.hotel.repository.HotelRepository;
import com.tramovel.tour.user.entity.User;
import com.tramovel.tour.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FreeBoardService {
  private final FreeBoardRepository freeBoardRepository;
  private final HotelRepository hotelRepository;
  private final UserRepository userRepository;
  public void upload(UploadRequestDTO requestDTO) {
    FreeBoard freeBoard = FreeBoard.builder()
      .content(requestDTO.getContent())
      .title(requestDTO.getTitle())
      .user(getUser(requestDTO.getId()))
      .movie(requestDTO.getMovie())
      .hotel(getHotel(requestDTO.getHotel()))
      .star(requestDTO.getStar())
      .build();
    freeBoardRepository.save(freeBoard);

  }

  public FreeBoardListDTO retrieve(Long hotel) {
    Hotel findHotel = getHotel(hotel);
    List<FreeBoard> entityList = freeBoardRepository.findAllByHotel(findHotel);
    List<FreeBoardDetailDTO> dtoList = entityList.stream().map(FreeBoardDetailDTO::new)
      .collect(Collectors.toList());
    return FreeBoardListDTO.builder().freeBoards(dtoList).build();
  }

  public Hotel getHotel(Long hotel) {
    return hotelRepository.findById(hotel).orElseThrow();
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
      .user(freeBoard.getUser())
      .uploadDate(freeBoard.getUploadDate())
      .hotel(freeBoard.getHotel())
      .build();
  }

  public void delete(long id) {
    try {
      freeBoardRepository.deleteById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public FreeBoardListDTO myList(String id) {
    User user = getUser(id);
    System.out.println("user = " + user);
    List<FreeBoard> entityList = freeBoardRepository.findAllByUser(user);
    List<FreeBoardDetailDTO> dtoList = entityList.stream().map(FreeBoardDetailDTO::new)
      .collect(Collectors.toList());
    return FreeBoardListDTO.builder().freeBoards(dtoList).build();
  }

  public User getUser(String id) {
    return userRepository.getReferenceById(id);
  }
}
