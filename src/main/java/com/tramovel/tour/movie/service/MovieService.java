package com.tramovel.tour.movie.service;

import com.tramovel.tour.movie.dto.response.MovieDetailDTO;
import com.tramovel.tour.movie.dto.response.MovieEnglishListDTO;
import com.tramovel.tour.movie.dto.response.MovieKoreanListDTO;
import com.tramovel.tour.movie.entity.Movie;
import com.tramovel.tour.movie.repository.ApplyListService;
import com.tramovel.tour.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

  private final MovieRepository movieRepository;
  private final ApplyListService applyListService;

  public MovieEnglishListDTO getEnglishMovieList() {
    List<Movie> movies = movieRepository.findAllByLanguageEn();

    List<MovieDetailDTO> dtoList = movies.stream()
      .map(MovieDetailDTO::new)
      .collect(Collectors.toList());
    return MovieEnglishListDTO.builder()
      .movieList(dtoList)
      .build();
  }

  public MovieKoreanListDTO getKoreanMovieList() {
    List<Movie> movies = movieRepository.findAllByLanguageKo();

    List<MovieDetailDTO> dtoList = movies.stream()
      .map(MovieDetailDTO::new)
      .collect(Collectors.toList());
    return MovieKoreanListDTO.builder()
      .movieList(dtoList)
      .build();
  }
}
