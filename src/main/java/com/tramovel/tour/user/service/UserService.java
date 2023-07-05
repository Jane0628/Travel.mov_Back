package com.tramovel.tour.user.service;

import com.tramovel.tour.user.dto.request.UserSignUpRequestDTO;
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

}
