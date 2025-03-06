package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsAccount;
import com.duydv.lms.repositories.LmsAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsAccountServiceImpl implements LmsAccountService {

  private LmsAccountRepository lmsAccountRepository;

  @Override
  public Page<LmsAccount> findAllPageable(Pageable pageable) {
    return lmsAccountRepository.findAll(pageable);
  }

  @Override
  public LmsAccount save(LmsAccount account) {
    return lmsAccountRepository.save(account);
  }

  @Override
  public LmsAccount findById(Integer id) {
    return lmsAccountRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsAccountRepository.deleteById(id);
  }
}
