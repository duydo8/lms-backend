package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsDistricts;
import com.duydv.lms.repositories.LmsDistrictsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LmsDistrictsServiceImpl implements LmsDistrictsService {

  private final LmsDistrictsRepository lmsDistrictssRepository;

  @Override
  public Page<LmsDistricts> findAllPageable(Pageable pageable) {
    return lmsDistrictssRepository.findAll(pageable);
  }

  @Override
  public LmsDistricts save(LmsDistricts districts) {
    return lmsDistrictssRepository.save(districts);
  }

  @Override
  public LmsDistricts findById(Integer id) {
    return lmsDistrictssRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsDistrictssRepository.deleteById(id);
  }
}
