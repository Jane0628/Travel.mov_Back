package com.tramovel.tour.reservation.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter @Setter
@ToString @EqualsAndHashCode(of = "partnerOrderId")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
public class Reservation {

  @Id
  @Column
  private String aid; //예약코드
  
  @Column(name = "partner_order_id")
  private String partnerOrderId; //회원 이름

  @Column
  private String tid; //결제코드

  @Column(name = "item_code")
  private String itemCode; //호텔코드

  @Column(name = "start_date")
  private String startDate; //체크인

  @Column(name = "end_date")
  private String endDate; //체크아웃

  @Column(name = "partner_user_id")
  private String partnerUserId; //예약자

  @Column(name = "item_name")
  private String itemName; //호텔이름

  @Column(name = "total_amount")
  private long totalAmount; //총 금액

  @CreationTimestamp
  private LocalDateTime resDate; //예약일자
}
