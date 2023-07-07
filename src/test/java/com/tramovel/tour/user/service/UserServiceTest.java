package com.tramovel.tour.user.service;

import com.tramovel.tour.user.dto.request.UserSignUpRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class UserServiceTest {

  @Autowired
  UserService userService;

  @Test
  @DisplayName("회원가입테스트")
  void signupTest() {
      //given
    UserSignUpRequestDTO dto = new UserSignUpRequestDTO().builder()
      .nick("기모찌")
      .pw("1q2w3e4r!")
      .id("abc1234")
      .name("김옥지")
      .email("abc1234@naver.com")
      .build();
      //when
      userService.signup(dto, "asdfasdfhlkaasdfhb");
      //then
  }

}