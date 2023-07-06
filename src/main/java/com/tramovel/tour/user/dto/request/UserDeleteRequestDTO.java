package com.tramovel.tour.user.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@EqualsAndHashCode @ToString
@NoArgsConstructor @AllArgsConstructor
public class UserDeleteRequestDTO {

  @NotBlank
  private String id;

}
