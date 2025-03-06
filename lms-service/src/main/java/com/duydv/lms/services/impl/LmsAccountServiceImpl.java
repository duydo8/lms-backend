package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsAccount;

import com.duydv.lms.repositories.LmsAccountRepository;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsAccountServiceImpl implements LmsAccountService {

  private final LmsAccountRepository lmsAccountRepository;

  @Override
  public LmsAccount findById(int id) {
    return lmsAccountRepository.findById(id).orElse(null);
  }
}
