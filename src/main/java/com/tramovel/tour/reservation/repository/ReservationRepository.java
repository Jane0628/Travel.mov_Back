package com.tramovel.tour.reservation.repository;

import com.tramovel.tour.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
