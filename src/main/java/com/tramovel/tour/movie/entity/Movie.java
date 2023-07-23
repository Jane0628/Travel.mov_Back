package com.tramovel.tour.movie.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@ToString @EqualsAndHashCode
@Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table
public class Movie {

  @Id
  private String id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String overview;

  @Column(nullable = false)
  private String posterPath;

  @Column(nullable = false)
  private String originalLanguage;

  @Column
  private String genre;

  //imdb에서의 검색을 위한 아이디(ex. tt013123)
  @Column(nullable = false)
  private String imdbId;

}
