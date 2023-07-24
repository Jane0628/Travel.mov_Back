package com.tramovel.tour.coupon.dto.request;

import lombok.*;

@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CouponCreateDTO {
  private String userId;
  private String name;
  private int discountRate;
  private int discountPrice;
}
