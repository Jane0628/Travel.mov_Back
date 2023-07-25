package com.tramovel.tour.coupon.dto.response;

import lombok.*;

import java.util.List;

@Getter @Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CouponListDTO {
  private List<CouponDTO> couponList;
}
