package com.tramovel.tour.kapi.service;

import com.tramovel.tour.kapi.dto.KakaoApproveResponse;
import com.tramovel.tour.kapi.dto.KakaoReadyRequest;
import com.tramovel.tour.kapi.dto.KakaoReadyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Transactional
public class KakaoPayService {

  @Value("${kakao.adminKey}")
  String adminKey;
  private  KakaoReadyResponse kakaoReady;
  String ptId;
  String usId;
  public KakaoReadyResponse kakaoPayReady(KakaoReadyRequest requestDTO) {
    System.out.println("adminKey = " + adminKey);
    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
    parameters.add("cid", "TC0ONETIME");
    parameters.add("partner_order_id", requestDTO.getPartnerOrderId());
    parameters.add("partner_user_id", requestDTO.getPartnerUserId());
    parameters.add("item_name", requestDTO.getItemName());
    parameters.add("quantity", requestDTO.getQuantity());
    parameters.add("total_amount", requestDTO.getTotalAmount());
    parameters.add("vat_amount", requestDTO.getVatAmount());
    parameters.add("tax_free_amount", requestDTO.getTaxFreeAmount());
    parameters.add("approval_url", "http://localhost:8181/pay/success"); // 성공 시 redirect url
    parameters.add("cancel_url", "http://localhost:8181/pay/cancel"); // 취소 시 redirect url
    parameters.add("fail_url", "http://localhost:8181/pay/fail"); // 실패 시 redirect url
    ptId = requestDTO.getPartnerOrderId();
    usId = requestDTO.getPartnerUserId();

    // 파라미터, 헤더
    HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

    // 외부에 보낼 url
    RestTemplate restTemplate = new RestTemplate();

    kakaoReady = restTemplate.postForObject(
      "https://kapi.kakao.com/v1/payment/ready",
      requestEntity,
      KakaoReadyResponse.class);
    System.out.println(kakaoReady.toString());

    return kakaoReady;
  }

  //헤더설정
  private HttpHeaders getHeaders() {
    HttpHeaders httpHeaders = new HttpHeaders();

    String auth = "KakaoAK " + adminKey;

    httpHeaders.set("Authorization", auth);
    httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

    return httpHeaders;
  }

  //결제 완료 승인
  public KakaoApproveResponse approveResponse(String pgToken) {

    // 카카오 요청
    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
    parameters.add("cid", "TC0ONETIME");
    parameters.add("tid", kakaoReady.getTid());
    parameters.add("partner_order_id", ptId);
    parameters.add("partner_user_id", usId);
    parameters.add("pg_token", pgToken);

    // 파라미터, 헤더
    HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

    // 외부에 보낼 url
    RestTemplate restTemplate = new RestTemplate();

    KakaoApproveResponse approveResponse = restTemplate.postForObject(
      "https://kapi.kakao.com/v1/payment/approve",
      requestEntity,
      KakaoApproveResponse.class);

    return approveResponse;
  }
}


