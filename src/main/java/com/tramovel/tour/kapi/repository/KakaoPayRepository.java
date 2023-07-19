package com.tramovel.tour.kapi.repository;

import com.tramovel.tour.kapi.entity.KakaoPay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoPayRepository extends JpaRepository<KakaoPay, String> {
}
