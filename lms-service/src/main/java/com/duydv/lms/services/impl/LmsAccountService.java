package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsAccountService {

  Page<LmsAccount> findAllPageable(Pageable pageable);
  LmsAccount save(LmsAccount account);
  LmsAccount findById(Integer id);
  void deleteById(Integer id);
}
