package com.tramovel.tour.movie.api;

import com.tramovel.tour.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/movie")
public class MovieController {

  private final MovieService movieService;

  //영어영화리스트 가져오기

  //한국영화리스트 가져오기

  //영화상세정보 가져오기

}
