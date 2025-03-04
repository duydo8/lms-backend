package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProvinces;
import com.duydv.lms.repositories.LmsProvincesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LmsProvincesServiceImpl implements LmsProvincesService {

  private final LmsProvincesRepository lmsProvincesRepository;

  public LmsProvincesServiceImpl(
      LmsProvincesRepository lmsProvincesRepository
  ) {
    this.lmsProvincesRepository = lmsProvincesRepository;
  }

  @Override
  public LmsProvinces findBySlug(String slug) {
    return lmsProvincesRepository.findBySlug(slug);
  }

  @Override
  public LmsProvinces findByCode(String code) {
    return lmsProvincesRepository.findByCode(code);
  }

  @Override
  public LmsProvinces findById(int i) {
    return lmsProvincesRepository.findById(i).orElse(null);
  }
}
