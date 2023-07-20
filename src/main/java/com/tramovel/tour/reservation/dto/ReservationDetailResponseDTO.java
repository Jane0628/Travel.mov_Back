package com.tramovel.tour.reservation.dto;

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
public class ReservationDetailResponseDTO {

  private String startDate; //체크인
  private String endDate; //체크아웃
  private String partnerOrderId; //예약자 이름
  private String itemName; //호텔 이름
  private LocalDateTime resDate; //예약 일자
  private long totalAmount; //총 금액

  public ReservationDetailResponseDTO(Reservation reservation) {
    this.startDate = reservation.getStartDate();
    this.endDate = reservation.getEndDate();
    this.partnerOrderId = reservation.getPartnerOrderId();
    this.itemName = reservation.getItemName();
    this.resDate = reservation.getResDate();
    this.totalAmount = reservation.getTotalAmount();
  }
}
