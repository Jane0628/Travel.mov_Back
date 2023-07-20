package com.tramovel.tour.reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.JoinColumn;
import java.time.LocalDateTime;
import java.util.List;

@Setter @Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationListResponseDTO {

  private String error; //에러 발생 시 에러 메세지를 담을 필드
  private List<ReservationDetailResponseDTO> reservationDTOS;

}
