package com.tramovel.tour.hotel.service;

import com.tramovel.tour.hotel.dto.AddHotelRequestDTO;
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

  public List<Hotel> getNHotels(String address) {
    System.out.println("address = " + address);
    return hotelRepository.findByAddress(address);
  }

  public Hotel getHotel(long id) {
    return hotelRepository.findById(id).orElseThrow();
  }

  public void addHotel(AddHotelRequestDTO dto) {
    hotelRepository.save(
      Hotel.builder()
        .img(dto.getImg())
        .price(dto.getPrice())
        .name(dto.getName())
        .address(dto.getAddress())
        .build()
    );
  }

  public void deleteHotel(long id) {
    hotelRepository.deleteById(id);
  }

  public Hotel getHotelByName(String name) {
    return hotelRepository.findByName(name);
  }

  public List<Hotel> getAllHotels() {
    return hotelRepository.findAll();
  }
}
