package com.tramovel.tour.reservation.service;

import com.tramovel.tour.kapi.dto.KakaoApproveResponse;
import com.tramovel.tour.reservation.dto.ReservationDetailResponseDTO;
import com.tramovel.tour.reservation.dto.ReservationListResponseDTO;
import com.tramovel.tour.reservation.entity.Reservation;
import com.tramovel.tour.reservation.repository.ReservationRepository;
import com.tramovel.tour.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationService {

  private final ReservationRepository reservationRepository;
  private final UserRepository userRepository;
  public void saveReservation(KakaoApproveResponse kakaoApprove,
                              String startDate, String endDate) {
   Reservation reservation = Reservation.builder()
     .aid(kakaoApprove.getAid())
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

  public ReservationListResponseDTO retrieve(String nick) {

    List<Reservation> entityList = reservationRepository.findAllByUser(nick);
    List<ReservationDetailResponseDTO> dtoList = entityList.stream().map(ReservationDetailResponseDTO::new)
      .collect(Collectors.toList());

    return ReservationListResponseDTO.builder().reservationDTOS(dtoList).build();
  }
}
