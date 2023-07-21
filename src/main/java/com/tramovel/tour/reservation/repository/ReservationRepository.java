package com.tramovel.tour.reservation.repository;

import com.tramovel.tour.reservation.entity.Reservation;
import com.tramovel.tour.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

  @Query(value = "SELECT * FROM reservation WHERE partner_user_id = :nick" , nativeQuery = true)
  List<Reservation> findAllByUser(String nick);

}
