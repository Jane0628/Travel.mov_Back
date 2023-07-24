package com.tramovel.tour.movie.dto.response;

import com.tramovel.tour.movie.entity.Genre;
import com.tramovel.tour.movie.entity.Movie;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDetailDTO {

  private Long movieId;
  private String title;
  private String overview;
  private String posterPath;
  private String imdbId;
  private LocalDateTime releaseDate;

  public MovieDetailDTO(Movie movie) {
    this.movieId = movie.getMovieId();
    this.title = movie.getTitle();
    this.overview = movie.getOverview();
    this.posterPath = movie.getPosterPath();
    this.imdbId = movie.getImdbId();
    this.releaseDate = movie.getReleaseDate();
  }

}
