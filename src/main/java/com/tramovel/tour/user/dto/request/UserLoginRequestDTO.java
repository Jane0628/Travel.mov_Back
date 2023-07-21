package com.tramovel.tour.user.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserLoginRequestDTO {

  @NotBlank
  private String id;

  @NotBlank
  private String pw;

  private String email;

}
