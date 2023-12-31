package com.tramovel.tour.hotel.api;

import com.tramovel.tour.auth.TokenUserInfo;
import com.tramovel.tour.hotel.dto.AddHotelRequestDTO;
import com.tramovel.tour.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
@Slf4j
@CrossOrigin
@RequiredArgsConstructor
public class HotelController {
  // 가정하에 HotelService를 이용해 호텔 데이터를 가져오는 메서드를 호출

  @Autowired
  private HotelService hotelService;

  @GetMapping("/address/{address}") //주소로 호텔 검색
  public ResponseEntity<?> getNHotels(@PathVariable("address") String address) {
    System.out.println("address = " + address);
    return ResponseEntity.ok().body(hotelService.getNHotels(address));
  }

  @GetMapping
  public ResponseEntity<?> getAllHotels() {
    return ResponseEntity.ok().body(hotelService.getAllHotels());
  }

  @GetMapping("/id/{id}") // 호텔아이디로 호텔 검색
  public ResponseEntity<?> getHotel(@PathVariable("id") long id) {
    System.out.println("id = " + id);
    return ResponseEntity.ok().body(hotelService.getHotel(id));
  }

  @PostMapping
  public void addHotel(@RequestBody AddHotelRequestDTO dto) {
    hotelService.addHotel(dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteHotel(@PathVariable("id") long id) {

    return ResponseEntity.ok().body(hotelService.deleteHotel(id));

  }

  @GetMapping("/name/{name}") // 호텔 이름으로 호텔 검색
  public ResponseEntity<?> getHotelByName(@PathVariable("name") String name) {
    System.out.println("name = " + name);
    try {
      return ResponseEntity.ok().body(hotelService.getHotelByName(name));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body("등록된 호텔이 없습니다.");
    }

  }
}