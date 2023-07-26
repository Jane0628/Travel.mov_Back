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

  private List<ReservationDetailResponseDTO> reservationDTOS;

}
