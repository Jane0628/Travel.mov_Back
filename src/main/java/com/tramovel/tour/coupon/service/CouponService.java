package com.tramovel.tour.coupon.service;

import com.tramovel.tour.coupon.dto.request.CouponCreateDTO;
import com.tramovel.tour.coupon.dto.response.CouponDTO;
import com.tramovel.tour.coupon.dto.response.CouponListDTO;
import com.tramovel.tour.coupon.entity.Coupon;
import com.tramovel.tour.coupon.repository.CouponRepository;
import com.tramovel.tour.reservation.dto.ReservationDetailResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CouponService {
  private final CouponRepository couponRepository;

  public void createCoupon(CouponCreateDTO requestDTO) {
    Coupon coupon = Coupon.builder()
      .userId(requestDTO.getUserId())
      .discountPrice(requestDTO.getDiscountPrice())
      .discountRate(requestDTO.getDiscountRate())
      .name(requestDTO.getName())
      .build();
    couponRepository.save(coupon);
  }

  public CouponListDTO getCouponList(String userId) {
     List<Coupon> couponList = couponRepository.findAllByUserId(userId);
    List<CouponDTO> dtoList = couponList.stream().map(CouponDTO::new)
      .collect(Collectors.toList());
    return CouponListDTO.builder().couponList(dtoList).build();
  }

  public void useCoupon(String couponId) {
    couponRepository.deleteById(couponId);
  }
}
