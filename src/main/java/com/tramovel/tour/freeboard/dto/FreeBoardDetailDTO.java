package com.tramovel.tour.freeboard.dto;

import com.tramovel.tour.freeboard.entity.FreeBoard;
import com.tramovel.tour.hotel.entity.Hotel;
import com.tramovel.tour.user.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeBoardDetailDTO {

  private long id;
  private String movie;
  private String title;
  private String content;
  private User user;
  private Hotel hotel;
  private int star;
  private LocalDateTime uploadDate;

  public FreeBoardDetailDTO(FreeBoard freeBoard) {
    this.id = freeBoard.getId();
    this.movie = freeBoard.getMovie();
    this.title = freeBoard.getTitle();
    this.content = freeBoard.getContent();
    this.user = freeBoard.getUser();
    this.hotel = freeBoard.getHotel();
    this.star = freeBoard.getStar();
    this.uploadDate = freeBoard.getUploadDate();
  }
}
