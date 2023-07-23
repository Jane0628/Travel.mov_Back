package com.tramovel.tour.movie.repository;

import com.tramovel.tour.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
