package com.tramovel.tour.auth;

import lombok.*;

@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class TokenUserInfo {

  private String id;
  private String email;
  private String nick;
  private String role;

}
