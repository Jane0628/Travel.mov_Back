package com.tramovel.tour.hotel.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class Hotel {

  @Id
  @Column(name = "hotel_id")
  private long id;

  @Column(name = "hotel_name")
  private String name;

  @Column
  private long price;

  @Column
  private String address;

  @Column
  private String img;

  @Column()
  @Builder.Default
  private boolean reservation = false;
}
