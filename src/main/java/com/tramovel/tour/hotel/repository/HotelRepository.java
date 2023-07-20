package com.tramovel.tour.hotel.repository;

import com.tramovel.tour.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
