package com.tramovel.tour.user.service;

import com.tramovel.tour.auth.TokenProvider;
import com.tramovel.tour.user.dto.request.UserDeleteRequestDTO;
import com.tramovel.tour.user.dto.request.UserLoginRequestDTO;
import com.tramovel.tour.user.dto.request.UserModifyRequestDTO;
import com.tramovel.tour.user.dto.request.UserSignUpRequestDTO;
import com.tramovel.tour.user.dto.response.UserLoginResponseDTO;
import com.tramovel.tour.user.entity.User;
import com.tramovel.tour.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder encoder;
  private final TokenProvider tokenProvider;

  @Value("${upload.path}")
  private String uploadRootPath;

  public void signup(final UserSignUpRequestDTO dto, String uploadedFilePath) throws RuntimeException {

    if(userRepository.existsById(dto.getId())) {
      log.warn("아이디가 중복되었습니다. {}", dto.getId());
      throw new RuntimeException("중복된 아이디 입니다.");
    }

    if(userRepository.existsByEmail(dto.getEmail())) {
      log.warn("이메일이 중복되었습니다. {}", dto.getEmail());
      throw new RuntimeException("중복된 이메일 입니다.");
    }

    dto.setPw(encoder.encode(dto.getPw()));

    User user = dto.toEntity(uploadedFilePath);

    userRepository.save(user);

  }

  public String uploadProfileImage(MultipartFile file) throws IOException {
    File RootDir = new File(uploadRootPath);
    if(!RootDir.exists()) RootDir.mkdir();

    String uuid = UUID.randomUUID() + "_" + file.getOriginalFilename();

    File uploadFile = new File(uploadRootPath + "/" + uuid);
    file.transferTo(uploadFile);

    return uuid;
  }

  //회원 인증
  public UserLoginResponseDTO authenticate(final UserLoginRequestDTO dto) {

    // ID로 회원 정보를 조회.
    User user = userRepository.findById(dto.getId())
      .orElseThrow(
        () -> new RuntimeException("가입된 회원이 아닙니다!")
      );

    //패스워드 검증
    String rawPassword = dto.getPw(); // 사용자가 입력한 비번
    String encodedPassword = user.getPw(); // DB에 저장된 비번

    if (!encoder.matches(rawPassword, encodedPassword)) {
      throw new RuntimeException("비밀번호가 틀렸습니다.");
    }

    log.info("{}님 로그인 성공!", user.getName());

    //로그인 성공 후에 클라이언트에게 JWT를 발급(리턴)
    String token = tokenProvider.createToken(user);//tokenprovier에게 user에관한 토큰 요청

    return new UserLoginResponseDTO(user, token); //user, token 을 loginresponseDTO에 전달.

    }


  public void modify(UserModifyRequestDTO dto, String profileImg) {

    User user = userRepository.findById(dto.getId()).orElseThrow(
      () -> new RuntimeException("회원 정보가 없습니다.")
    );

    //기존 이미지 지우기
    File file = new File(uploadRootPath + "/" + user.getProfileImg());
    if(file.exists()) {
      if(file.delete()) {
        log.info("삭제 성공");
      } else {
        log.info("삭제 실패");
      }
    }

    //회원 정보 수정
    dto.setPw(encoder.encode(dto.getPw()));
    user.setPw(dto.getPw());
    user.setNick(dto.getNick());
    user.setEmail(dto.getEmail());
    user.setProfileImg(profileImg);

    userRepository.save(user);

  }

  public void delete(UserDeleteRequestDTO dto) {
    User user = userRepository.findById(dto.getId()).orElseThrow(
      () -> new RuntimeException("가입된 회원이 아닙니다!")
    );

    //이미지 지우기
    File file = new File(uploadRootPath + "/" + user.getProfileImg());
    if(file.exists()) {
      if (file.delete()) {
        log.info("삭제 성공");
      } else {
        log.info("삭제 실패");
      }
    }

    //회원 탈퇴
    userRepository.deleteById(dto.getId());
  }

  public boolean isDuplicate(String id) {
    return userRepository.existsById(id);
  }
}