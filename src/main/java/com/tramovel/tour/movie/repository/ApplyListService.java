package com.tramovel.tour.movie.repository;

import com.tramovel.tour.movie.entity.ApplyList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyListService extends JpaRepository<ApplyList, Long> {
}
