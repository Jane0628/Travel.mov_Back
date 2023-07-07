package com.tramovel.tour.user.repository;

import com.tramovel.tour.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

  boolean existsByEmail(String email);
}
