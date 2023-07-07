package com.tramovel.tour.user.repository;

import com.tramovel.tour.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

  boolean existsByEmail(String email);

  //아이디 중복체크
  boolean existsById(String id);// id 존재하면 true 아니면 false
}
