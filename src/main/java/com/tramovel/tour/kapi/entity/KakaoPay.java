package com.tramovel.tour.kapi.entity;

import com.tramovel.tour.kapi.dto.KakaoApproveResponse;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @Setter
@ToString @EqualsAndHashCode(of = "tid")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table
public class KakaoPay {

  @Id
  @Column
  private String tid; // 결제 고유 번호

  @Column
  private String aid; // 요청 고유 번호

  @Column
  private String cid; // 가맹점 코드

  @Column
  private String sid; // 정기결제용 ID

  @Column
  private String partner_order_id; // 가맹점 주문 번호

  @Column
  private String partner_user_id; // 가맹점 회원 id

  @Column
  private String payment_method_type; // 결제 수단

  @Column
  private long total; //총금액

  @Column
  private long tax_free; //비과세

  @Column
  private long tax; //부과세

  @Column
  private long point; //포인트
  
  @Column
  private long discount; //할인금액

  @Column
  private long green_doposit; //컵보증금

  @Column
  private String item_name; // 상품명

  @Column
  private String item_code; // 상품 코드

  @Column
  private int quantity; // 상품 수량

  @Column
  private String created_at; // 결제 요청 시간

  @Column
  private String approved_at; // 결제 승인 시간

  @Column
  private String payload; // 결제 승인 요청에 대해 저장 값, 요청 시 전달 내용
}
