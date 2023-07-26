package com.tramovel.tour.coupon.api;

import com.tramovel.tour.auth.TokenUserInfo;
import com.tramovel.tour.coupon.dto.request.CouponCreateDTO;
import com.tramovel.tour.coupon.dto.response.CouponDTO;
import com.tramovel.tour.coupon.dto.response.CouponListDTO;
import com.tramovel.tour.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/coupon")
public class CouponController {
  private final CouponService couponService;

//  회원가입 쪽으로 옮김
//  @PostMapping
//  public ResponseEntity<?> createCoupon (CouponCreateDTO requestDTO) {
//    try {
//      couponService.createCoupon(requestDTO);
//      return ResponseEntity.ok().body("쿠폰생성완료");
//    } catch (Exception e) {
//      e.printStackTrace();
//      return ResponseEntity.badRequest().body("잘못된 요청");
//    }
//  }

  @GetMapping
  public ResponseEntity<?> getCouponList(@AuthenticationPrincipal TokenUserInfo userInfo) {
    try {
      CouponListDTO couponList = couponService.getCouponList(userInfo.getId());
      System.out.println("couponList = " + couponList);
      return ResponseEntity.ok().body(couponList);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body("로그인 먼저 해주세요");
    }
  }

}
