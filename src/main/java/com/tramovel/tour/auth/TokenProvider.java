package com.tramovel.tour.auth;

import com.tramovel.tour.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TokenProvider {

  @Value("${jwt.secret}")
  private String SECRET_KEY;

  public String createToken(User userEntity) {

    Date expiry = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));

    Map<String, Object> claims = new HashMap<>();
    claims.put("nick", userEntity.getNick());
    claims.put("email", userEntity.getEmail());

    return Jwts.builder()
      .signWith(
        Keys.hmacShaKeyFor(SECRET_KEY.getBytes()),
        SignatureAlgorithm.HS512
      )
      .setClaims(claims)
      .setIssuer("대장")
      .setIssuedAt(new Date())
      .setExpiration(expiry)
      .setSubject(userEntity.getId())
      .compact();

  }

  public TokenUserInfo validateUserInfo(String token) {

    Claims claims = Jwts.parserBuilder()
      .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
      .build()
      .parseClaimsJws(token)
      .getBody();

    log.info("Clainms : {}", claims);

    return TokenUserInfo.builder()
      .id(claims.getSubject())
      .email(claims.get("email", String.class))
      .nick(claims.get("nick", String.class))
      .build();

  }

}
