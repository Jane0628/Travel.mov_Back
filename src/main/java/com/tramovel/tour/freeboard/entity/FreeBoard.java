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
  private String title;

  @Column
  private String content;

  @Column
  private String userNick;

  @CreationTimestamp
  private LocalDateTime uploadDate;
}
