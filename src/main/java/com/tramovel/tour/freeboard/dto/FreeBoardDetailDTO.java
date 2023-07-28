package com.tramovel.tour.freeboard.dto;

import com.tramovel.tour.freeboard.entity.FreeBoard;
import com.tramovel.tour.hotel.entity.Hotel;
import com.tramovel.tour.reservation.entity.Reservation;
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
  private String userNick;
  private Hotel hotel;
  private int star;
  private LocalDateTime uploadDate;

  public FreeBoardDetailDTO(FreeBoard freeBoard) {
    this.id = freeBoard.getId();
    this.movie = freeBoard.getMovie();
    this.title = freeBoard.getTitle();
    this.content = freeBoard.getContent();
    this.userNick = freeBoard.getUserNick();
    this.hotel = freeBoard.getHotel();
    this.star = freeBoard.getStar();
    this.uploadDate = freeBoard.getUploadDate();
  }
}
