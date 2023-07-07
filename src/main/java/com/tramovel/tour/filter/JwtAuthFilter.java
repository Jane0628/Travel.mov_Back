package com.tramovel.tour.filter;

import com.tramovel.tour.auth.TokenProvider;
import com.tramovel.tour.auth.TokenUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

  @Autowired
  private TokenProvider tokenProvider;

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {

    try {
      String token = parseBearerToken(request);
      log.info("Jwt Token Filter is running    token: {}", token);

      if(token != null) {
        TokenUserInfo userInfo = tokenProvider.validateUserInfo(token);

        AbstractAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userInfo, null, null);

        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(auth);

      }
    } catch (Exception e) {
      e.printStackTrace();
      log.error("토큰이 위조 되었거나 토큰이 만료됨");
    }

    filterChain.doFilter(request, response);

  }

  private String parseBearerToken(HttpServletRequest request) {

    // 요청 헤더에서 토큰 가져오기
    // http request header
    // -- Content-type : application/json
    // -- Authorization : Bearer asjkldjaslkd32$dsakfjlds
    String bearerToken = request.getHeader("Authorization");

    // 요청 헤더에서 가져온 토큰은 순수 토큰 값이 아닌
    // 앞에 Bearer가 붙어있으니 이것을 제거하는 작업
    if(StringUtils.hasText(bearerToken)
      && bearerToken.startsWith("Bearer")) {
      return bearerToken.substring(7);
    }
    return null;
  }

}
