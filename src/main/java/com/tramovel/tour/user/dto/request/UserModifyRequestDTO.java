package com.tramovel.tour.user.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserModifyRequestDTO {

  private String id;

  private String nick;
  @Email
  private String email;

}
