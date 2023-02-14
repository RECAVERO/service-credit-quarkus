package com.nttdata.domain.models;

import com.nttdata.infraestructure.entity.Credit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
  private String status;
  private String message;
  private List<Credit> credit;
}
