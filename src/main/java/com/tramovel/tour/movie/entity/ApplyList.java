package com.tramovel.tour.movie.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class ApplyList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long applyId;

  @ManyToOne
  @JoinColumn
  private Movie movie;

  @ManyToOne
  @JoinColumn
  private Genre genre;
}
