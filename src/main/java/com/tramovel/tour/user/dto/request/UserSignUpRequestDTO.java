package com.tramovel.tour.user.dto.request;

import com.tramovel.tour.user.entity.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserSignUpRequestDTO {

  @NotBlank
  private String id;

  @NotBlank
  private String pw;

  @NotBlank
  private String name;

  private String nick;

  @NotBlank
  @Email
  private String email;

  public void setPw(String pw) {
    this.pw = pw;
  }

  public User toEntity(String uploadedFilePath) {
    return User.builder()
      .id(this.id)
      .pw(this.pw)
      .name(this.name)
      .nick(this.nick)
      .email(this.email)
      .profileImg(uploadedFilePath)
      .build();
  }

}
