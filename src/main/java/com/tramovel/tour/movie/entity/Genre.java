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
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long genreId;

  private String genre;


}
