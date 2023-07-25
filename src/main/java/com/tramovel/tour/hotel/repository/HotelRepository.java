package com.tramovel.tour.hotel.repository;

import com.tramovel.tour.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, String> {
  @Query(value = "SELECT * FROM hotel WHERE address LIKE '%:address%'" , nativeQuery = true)
  List<Hotel> findByAddress(String address);
}
