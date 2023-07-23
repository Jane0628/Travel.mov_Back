package com.tramovel.tour.movie.dto.response;

import lombok.*;

import java.util.List;

@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class MovieKoreanListDTO {

  private List<MovieDetailDTO> movieList;

}
