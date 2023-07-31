package com.tramovel.tour.freeboard.dto;

import com.tramovel.tour.user.entity.User;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UploadRequestDTO {

  private String id;
  @NotBlank
  private String title;
  @NotBlank
  private String content;

  private int star;

  private String movie;

  private long hotel;
}
