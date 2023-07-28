package com.tramovel.tour.hotel.repository;

import com.tramovel.tour.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
  @Query(value = "SELECT * FROM hotel WHERE address LIKE %:address%" , nativeQuery = true)
  List<Hotel> findByAddress(@Param("address") String address);

  @Query(value = "SELECT * FROM hotel WHERE hotel_name = :name", nativeQuery = true)
  Hotel findByName(String name);
}
