package com.tramovel.tour.user.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.tramovel.tour.user.entity.User;
import lombok.*;

import java.time.LocalDate;

@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserLoginResponseDTO {

  private String id;
  private String email;
  private String name;
  private String nick;

  @JsonFormat(pattern = "yyyy년 MM월 dd일")
  private LocalDate joinDate;

  private String token; // 인증토큰

  public UserLoginResponseDTO(User user, String token) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.nick = user.getNick();
    this.joinDate = LocalDate.from(user.getJoinDate());
    this.token = token;
  }

}
