package com.duydv.lms.services.impl;

import com.duydv.lms.dtos.request.AccountFindAllRequest;
import com.duydv.lms.entities.LmsAccount;
import org.springframework.data.domain.Page;

public interface LmsAccountService {

  Page<LmsAccount> findAllPageable(AccountFindAllRequest accountFindAllRequest);

  LmsAccount save(LmsAccount account);

  LmsAccount findById(Integer id);

  void deleteById(Integer id);

  LmsAccount findByPhone(String phone);

  LmsAccount findByPhoneAndPassword(String phone, String password);
}
