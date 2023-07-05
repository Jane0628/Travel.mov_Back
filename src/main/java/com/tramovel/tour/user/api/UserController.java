package com.tramovel.tour.user.api;

import com.tramovel.tour.user.dto.request.UserLoginRequestDTO;
import com.tramovel.tour.user.dto.request.UserSignUpRequestDTO;
import com.tramovel.tour.user.dto.response.UserLoginResponseDTO;
import com.tramovel.tour.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    String uploadedFilePath = null;
    if(profileImg != null) {

    }
    userService.signup(dto, uploadedFilePath);

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

}
