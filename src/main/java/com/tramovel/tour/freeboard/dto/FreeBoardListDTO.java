package com.tramovel.tour.freeboard.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeBoardListDTO {
  private List<FreeBoardDetailDTO> freeBoards;
}
