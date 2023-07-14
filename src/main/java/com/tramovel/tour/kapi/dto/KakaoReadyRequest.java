package com.tramovel.tour.kapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoReadyRequest {

  @JsonProperty("partner_order_id")
  private String partnerOrderId;
  @JsonProperty("partner_user_id")
  private String partnerUserId;
  @JsonProperty("item_name")
  private String itemName;
  @JsonProperty("quantity")
  private String quantity;
  @JsonProperty("total_amount")
  private String totalAmount;
  @JsonProperty("vat_amount")
  private String vatAmount;
  @JsonProperty("tax_free_amount")
  private String taxFreeAmount;
}
