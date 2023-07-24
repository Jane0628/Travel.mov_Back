package com.tramovel.tour.coupon.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table
public class Coupon {

  @Id
  @Column(name = "coupon_id")
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;

  @Column(name = "coupon_name")
  private String name; //쿠폰이름

  @Column
  private int discountRate; // 할인율

  @Column
  private int discountPrice; // 할인가

  @Column
  private String userId; // 사용자

  @Column
  @Builder.Default
  private int status = 1; // 사용가능 1 사용불가 0

  @CreationTimestamp
  private LocalDateTime createDate; //생성일

  @Column
  @Builder.Default
  private LocalDateTime endDate = LocalDateTime.now().plusDays(7); //만료일 기본값 생성일 +7

}
