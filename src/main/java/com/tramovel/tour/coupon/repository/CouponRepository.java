package com.tramovel.tour.coupon.repository;

import com.tramovel.tour.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, String> {

  @Query(value = "SELECT * FROM coupon WHERE user_id = :userId" , nativeQuery = true)
  List<Coupon> findAllByUserId(String userId);
}
