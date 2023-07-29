package com.tramovel.tour.freeboard.repository;

import com.tramovel.tour.freeboard.entity.FreeBoard;
import com.tramovel.tour.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {

  @Query(value = "SELECT * FROM free_board WHERE movie = :movie" , nativeQuery = true)
  List<FreeBoard> findAllByMovie(String movie);

  @Query(value = "SELECT * FROM free_board WHERE user_nick = :nick" , nativeQuery = true)
  List<FreeBoard> findAllByNick(String nick);



  @Query("SELECT f FROM FreeBoard f WHERE f.hotel = :hotel")
  List<FreeBoard> findAllByHotel(Hotel hotel);
}
