package com.duydv.lms.dtos.request;

import lombok.Data;

@Data
public class AccountFindAllRequest {
  private Integer page;
  private Integer size;
  private String fullName;
}
