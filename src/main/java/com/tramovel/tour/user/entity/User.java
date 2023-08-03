package com.tramovel.tour.user.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter @Setter
@ToString @EqualsAndHashCode(of = "id")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
@Table
public class User {

  @Id
  @Column(name = "user_id")
  private String id;

  @Column(nullable = false, name = "user_pw")
  private String pw;

  @Column(nullable = false, name = "user_nick")
  private String nick;

  @Column(unique = true, nullable = false)
  private String email;

  @CreationTimestamp
  private LocalDateTime joinDate;

  private String profileImg;

  @Builder.Default
  private String role = "일반회원";

}
