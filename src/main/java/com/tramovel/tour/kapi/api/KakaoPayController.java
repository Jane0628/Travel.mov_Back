package com.tramovel.tour.kapi.api;

import com.tramovel.tour.kapi.dto.KakaoApproveResponse;
import com.tramovel.tour.kapi.dto.KakaoReadyRequest;
import com.tramovel.tour.kapi.dto.KakaoReadyResponse;
import com.tramovel.tour.kapi.service.KakaoPayService;
import com.tramovel.tour.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@RestController
@RequestMapping("/pay")
@CrossOrigin
@RequiredArgsConstructor
public class KakaoPayController {
  private final KakaoPayService kakaoPayService;
  private final ReservationService reservationService;

  @PostMapping("/ready")
  public KakaoReadyResponse ready(@RequestBody KakaoReadyRequest requestDTO) {
    System.out.println(requestDTO.getItemName());
    log.info("req"+ requestDTO.toString());

    return kakaoPayService.kakaoPayReady(requestDTO);
  }

  @GetMapping("/success")
  public RedirectView afterPayRequest(@RequestParam("pg_token") String pgToken) {

    KakaoApproveResponse kakaoApprove = kakaoPayService.approveResponse(pgToken);

    reservationService.saveReservation(kakaoApprove);
    System.out.println("kakaoApprove = " + kakaoApprove);
    RedirectView redirectView = new RedirectView();
    redirectView.setUrl("http://localhost:3000/reservationCheck");

    return redirectView;
  }

  @GetMapping("/cancel")
  public ResponseEntity cancel() {

    return ResponseEntity.badRequest().body("결제가 취소되었습니다.");
  }
  @GetMapping("/fail")
  public ResponseEntity fail() {

    return ResponseEntity.badRequest().body("결제 실패.");
  }
}
