package com.tramovel.tour.hotel.service;

import com.tramovel.tour.hotel.entity.Hotel;
import com.tramovel.tour.hotel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class HotelService {
  @Autowired
  private HotelRepository hotelRepository;

  public List<Hotel> getAllHotels(String address) {
    System.out.println("address = " + address);
    return hotelRepository.findByAddress(address);
  }

  public Hotel getHotel(long id) {
    return hotelRepository.findById(id).orElseThrow();
  }
}
