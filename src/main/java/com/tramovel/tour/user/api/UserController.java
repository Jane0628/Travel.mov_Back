package com.tramovel.tour.user.api;

import com.tramovel.tour.user.dto.request.UserDeleteRequestDTO;
import com.tramovel.tour.user.dto.request.UserLoginRequestDTO;
import com.tramovel.tour.user.dto.request.UserModifyRequestDTO;
import com.tramovel.tour.user.dto.request.UserSignUpRequestDTO;
import com.tramovel.tour.user.dto.response.UserLoginResponseDTO;
import com.tramovel.tour.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  //회원가입
  @PostMapping
  public void signup(
    @Validated @RequestPart("user") UserSignUpRequestDTO dto,
    @RequestPart(value = "profileImage", required = false) MultipartFile profileImg,
    BindingResult result
  ) {

    if(result.hasErrors()) { // 입력값 검증에 걸림
      List<FieldError> fieldErrors = result.getFieldErrors();
      fieldErrors.forEach(err -> {
        log.warn("invalid client data - {}", err.toString());
      });

//      return ResponseEntity
//        .badRequest()
//        .body(fieldErrors);
    }

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

  //아이디 중복 확인 요청처리
  @GetMapping("/check")
  public ResponseEntity<?> check(String id) {
    if(id.equals("")) {
      return ResponseEntity.badRequest()
              .body("아이디가 없습니다!");
    }
    boolean result = userService.isDuplicate(id); // 중복되었니?

    return ResponseEntity.ok().body(result);
  }


  //로그인 요청 처리
  @PostMapping("/signin")
  public ResponseEntity<?> signIn(
    @Validated @RequestBody UserLoginRequestDTO dto,   //json으로 넘어오는 데이터는 @requestbody로 자바객체로 변환.
    BindingResult result
  ) {
    if(result.hasErrors()) { // 입력값 검증에 걸림
      List<FieldError> fieldErrors = result.getFieldErrors();
      fieldErrors.forEach(err -> {
        log.warn("invalid client data - {}", err.toString());
      });

      return ResponseEntity
        .badRequest()
        .body(fieldErrors);
    }

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

  //회원 정보 수정
  @PutMapping
  public void modify(
    @Validated @RequestPart(value = "user") UserModifyRequestDTO dto,
    @RequestPart(value = "profileImage", required = false) MultipartFile profileImg,
    BindingResult result
  ) {
    if(result.hasErrors()) { // 입력값 검증에 걸림
      List<FieldError> fieldErrors = result.getFieldErrors();
      fieldErrors.forEach(err -> {
        log.warn("invalid client data - {}", err.toString());
      });

//      return ResponseEntity
//        .badRequest()
//        .body(fieldErrors);
    }

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

  //회원 탈퇴
  @DeleteMapping
  public void delete(
    @Validated @RequestBody UserDeleteRequestDTO dto,
    BindingResult result
    ) {
    if(result.hasErrors()) { // 입력값 검증에 걸림
      List<FieldError> fieldErrors = result.getFieldErrors();
      fieldErrors.forEach(err -> {
        log.warn("invalid client data - {}", err.toString());
      });

//      return ResponseEntity
//        .badRequest()
//        .body(fieldErrors);
    }

    userService.delete(dto);
  }

}
