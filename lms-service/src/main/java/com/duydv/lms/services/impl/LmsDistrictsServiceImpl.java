package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsDistricts;
import com.duydv.lms.repositories.LmsDistrictsRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LmsDistrictsServiceImpl implements LmsDistrictsService {

  private final LmsDistrictsRepository lmsDistrictsRepository;

  public LmsDistrictsServiceImpl(
      LmsDistrictsRepository lmsDistrictsRepository
  ) {
    this.lmsDistrictsRepository = lmsDistrictsRepository;
  }

  @Override
  public List<LmsDistricts> findByProvinceCode(String provinceCode) {
    return lmsDistrictsRepository.findByProvinceCode(provinceCode);
  }

  @Override
  public LmsDistricts findBySlug(String slug) {
    return lmsDistrictsRepository.findBySlug(slug);
  }

  @Override
  public LmsDistricts findById(int i) {
    return lmsDistrictsRepository.findById(i).orElse(null);
  }
}
