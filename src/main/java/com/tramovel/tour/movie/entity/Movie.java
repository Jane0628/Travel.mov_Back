package com.tramovel.tour.movie.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString @EqualsAndHashCode
@Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long movieId;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false, length = 1000)
  private String overview;

  @Column(nullable = false)
  private String posterPath;

  // imdb에서의 검색을 위한 아이디 (ex. tt013123)
  @Column(nullable = false)
  private String imdbId;

  private LocalDateTime releaseDate;

}
