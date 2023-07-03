package com.tramovel.tour.user.repository;

import com.tramovel.tour.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

  @Query("SELECT COUNT(*) FROM User u WHERE u.email = ?1")
  boolean existsByEmail(String email);
}
