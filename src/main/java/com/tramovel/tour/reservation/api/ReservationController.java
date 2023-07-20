package com.tramovel.tour.reservation.api;

import com.tramovel.tour.auth.TokenUserInfo;
import com.tramovel.tour.reservation.dto.ReservationListResponseDTO;
import com.tramovel.tour.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/reservation")
@CrossOrigin
@RequiredArgsConstructor
public class ReservationController {
  private final ReservationService reservationService;

  @GetMapping
  public ResponseEntity<?> getList(@AuthenticationPrincipal TokenUserInfo userInfo) {
  log.info("/reservation Post");
  ReservationListResponseDTO responseDTOList = reservationService.retrieve(userInfo.getNick());
    System.out.println("responseDTOList = " + responseDTOList);

    return ResponseEntity.ok().body(responseDTOList);
  }

}
