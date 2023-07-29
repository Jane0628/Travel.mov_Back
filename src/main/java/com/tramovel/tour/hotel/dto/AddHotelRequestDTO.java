package com.tramovel.tour.hotel.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
public class AddHotelRequestDTO {

  private String name;
  private long price;
  private String img;
  private String address;

}
