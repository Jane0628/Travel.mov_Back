package com.tramovel.tour.user.api;

import com.tramovel.tour.user.dto.request.UserSignUpRequestDTO;
import com.tramovel.tour.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
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

}
