package com.tramovel.tour.movie.repository;

import com.tramovel.tour.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  @Query("SELECT m FROM Movie m WHERE m.originalLanguage = 'ko'")
  List<Movie> findAllByLanguageKo();

  @Query("SELECT m FROM Movie m WHERE m.originalLanguage = 'en'")
  List<Movie> findAllByLanguageEn();
}
