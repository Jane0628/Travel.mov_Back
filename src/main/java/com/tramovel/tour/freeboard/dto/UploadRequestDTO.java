package com.tramovel.tour.freeboard.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UploadRequestDTO {

  private String userNick;
  @NotBlank
  private String title;
  @NotBlank
  private String content;
}
