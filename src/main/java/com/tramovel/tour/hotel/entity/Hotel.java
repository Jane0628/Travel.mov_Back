package com.tramovel.tour.hotel.entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class Hotel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "hotel_id")
  private long id; //호텔 번호

  @Column(name = "hotel_name")
  private String name; //호텔 이름

  @Column
  private long price; //1박 가격

  @Column
  private String address; //호텔 주소

  @Column
  private String img; //이미지 주소url

  @Column()
  @Builder.Default
  private int reservation = 1; //예약가능 1 예약중 0
}
