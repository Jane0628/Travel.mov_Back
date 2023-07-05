package com.tramovel.tour.user.dto.request;

import com.tramovel.tour.user.entity.User;
import lombok.*;

import javax.validation.constraints.Email;

@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserModifyRequestDTO {

  private String id;
  private String pw;
  private String nick;
  @Email
  private String email;
  public void setPw(String pw) {
    this.pw = pw;
  }

}
