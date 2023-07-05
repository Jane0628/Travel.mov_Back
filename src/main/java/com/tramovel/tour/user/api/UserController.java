package com.tramovel.tour.user.api;

import com.tramovel.tour.user.dto.request.UserLoginRequestDTO;
import com.tramovel.tour.user.dto.request.UserModifyRequestDTO;
import com.tramovel.tour.user.dto.request.UserSignUpRequestDTO;
import com.tramovel.tour.user.dto.response.UserLoginResponseDTO;
import com.tramovel.tour.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public void signup(
    @Validated @RequestPart("user") UserSignUpRequestDTO dto,
    @RequestPart(value = "profileImage", required = false) MultipartFile profileImg,
    BindingResult result
  ) {

    try {
      String uploadedFilePath = null;
      if(profileImg != null) {
        uploadedFilePath = userService.uploadProfileImage(profileImg);
      }
      userService.signup(dto, uploadedFilePath);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  //로그인 요청 처리
  @PostMapping("/signin")
  public ResponseEntity<?> signIn(
    @Validated @RequestBody UserLoginRequestDTO dto   //json으로 넘어오는 데이터는 @requestbody로 자바객체로 변환.
  ) {
    try {
      UserLoginResponseDTO responseDTO
        = userService.authenticate(dto);

      return ResponseEntity.ok().body(responseDTO);

    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest()
        .body(e.getMessage());
    }
  }

  @PutMapping
  public void modify(
    @Validated @RequestPart(value = "user") UserModifyRequestDTO dto,
    @RequestPart(value = "profileImage", required = false) MultipartFile profileImg,
    BindingResult result
  ) {
    try {
      String uploadedFilePath = null;
      if(profileImg != null) {
        uploadedFilePath = userService.uploadProfileImage(profileImg);
      }
      userService.modify(dto, uploadedFilePath);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

}
