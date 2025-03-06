package com.duydv.lms.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
  private Object data;
  private int code;
  private String message;

  public BaseResponse(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
