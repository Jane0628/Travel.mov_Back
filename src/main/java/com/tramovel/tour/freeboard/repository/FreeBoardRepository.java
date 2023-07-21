package com.tramovel.tour.freeboard.repository;

import com.tramovel.tour.freeboard.entity.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
}
