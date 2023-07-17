package com.tramovel.tour.user.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserModifyRequestDTO {

  @NotBlank
  private String id;
  private String pw;
  private String nick;
  @Email
  private String email;
  public void setPw(String pw) {
    this.pw = pw;
  }

}
