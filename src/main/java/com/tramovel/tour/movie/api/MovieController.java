package com.tramovel.tour.movie.api;

import com.tramovel.tour.movie.dto.response.MovieEnglishListDTO;
import com.tramovel.tour.movie.dto.response.MovieKoreanListDTO;
import com.tramovel.tour.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/movie")
public class MovieController {

  private final MovieService movieService;

  //영어영화리스트 가져오기
  @PostMapping("/en")
  public ResponseEntity<?> getEnglishMovieList() {
    MovieEnglishListDTO responseDTO = movieService.getEnglishMovieList();
    return ResponseEntity.ok().body(responseDTO);
  }
  //한국영화리스트 가져오기
  @PostMapping("/ko")
  public ResponseEntity<?> getKoreanMovieList() {
    MovieKoreanListDTO responseDTO = movieService.getKoreanMovieList();
    return ResponseEntity.ok().body(responseDTO);
  }

  //영화상세정보 가져오기

}
