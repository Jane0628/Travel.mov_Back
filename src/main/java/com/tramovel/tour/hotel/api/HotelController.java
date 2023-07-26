package com.tramovel.tour.hotel.api;

import com.tramovel.tour.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels")
@Slf4j
@CrossOrigin
@RequiredArgsConstructor
public class HotelController {
  // 가정하에 HotelService를 이용해 호텔 데이터를 가져오는 메서드를 호출

  @Autowired
  private HotelService hotelService;

  @GetMapping("/{address}")
  public ResponseEntity<?> getAllHotels(@PathVariable("address") String address) {
    System.out.println("address = " + address);
    return ResponseEntity.ok().body(hotelService.getAllHotels(address));
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<?> getHotel(@PathVariable("id") long id) {
    System.out.println("id = " + id);
    return ResponseEntity.ok().body(hotelService.getHotel(id));
  }
}
