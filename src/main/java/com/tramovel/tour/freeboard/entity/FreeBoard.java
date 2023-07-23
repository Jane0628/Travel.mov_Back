package com.tramovel.tour.freeboard.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table
public class FreeBoard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "free_id")
  private long id;

  @Column
  private String movie; //영화 이름

  @Column
  private String title; //제목

  @Column
  private String content; //내용

  @Column
  private String userNick; //작성자

  @Column
  private int star; //별점

  @CreationTimestamp
  private LocalDateTime uploadDate;
}
