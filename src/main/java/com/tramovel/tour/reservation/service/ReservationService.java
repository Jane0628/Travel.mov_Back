package com.tramovel.tour.reservation.service;

import com.tramovel.tour.kapi.dto.KakaoApproveResponse;
import com.tramovel.tour.reservation.entity.Reservation;
import com.tramovel.tour.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationService {

  private final ReservationRepository reservationRepository;
  public void saveReservation(KakaoApproveResponse kakaoApprove,
                              LocalDateTime startDate, LocalDateTime endDate) {
   Reservation reservation = Reservation.builder()
     .partnerOrderId(kakaoApprove.getPartner_order_id())
     .tid(kakaoApprove.getTid())
     .itemCode(kakaoApprove.getItem_code())
     .startDate(startDate)
     .endDate(endDate)
     .partnerUserId(kakaoApprove.getPartner_user_id())
     .itemName(kakaoApprove.getItem_name())
     .totalAmount(kakaoApprove.getAmount().getTotal())
     .build();
      reservationRepository.save(reservation);
  }
}
