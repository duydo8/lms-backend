package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProvinces;
import com.duydv.lms.repositories.LmsProvincesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LmsProvincesServiceImpl implements LmsProvincesService {

  private LmsProvincesRepository lmsProvincesRepository;

  @Override
  public Page<LmsProvinces> findAllPageable(Pageable pageable) {
    return lmsProvincesRepository.findAll(pageable);
  }

  @Override
  public LmsProvinces save(LmsProvinces Provinces) {
    return lmsProvincesRepository.save(Provinces);
  }

  @Override
  public LmsProvinces findById(Integer id) {
    return lmsProvincesRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsProvincesRepository.deleteById(id);
  }
}
