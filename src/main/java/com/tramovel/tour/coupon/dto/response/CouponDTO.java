package com.tramovel.tour.coupon.dto.response;

import com.tramovel.tour.coupon.entity.Coupon;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CouponDTO {
  private String id;
  private int discountRate;
  private int discountPrice;
  private String userId;
  private int status;
  private LocalDateTime createDate;
  private LocalDateTime endDate;

  public CouponDTO(Coupon coupon) {
    this.id = coupon.getId();
    this.discountRate = coupon.getDiscountRate();
    this.discountPrice = coupon.getDiscountPrice();
    this.userId = coupon.getUserId();
    this.status = coupon.getStatus();
    this.createDate = coupon.getCreateDate();
    this.endDate = coupon.getEndDate();
  }
}
