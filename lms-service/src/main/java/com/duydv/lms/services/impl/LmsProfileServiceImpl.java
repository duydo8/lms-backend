package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProfile;
import com.duydv.lms.repositories.LmsProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsProfileServiceImpl implements LmsProfileService {

  private final LmsProfileRepository lmsProfileRepository;

  @Override
  public Page<LmsProfile> findAllPageable(Pageable pageable) {
    return lmsProfileRepository.findAll(pageable);
  }

  @Override
  public LmsProfile save(LmsProfile lmsProfile) {
    return lmsProfileRepository.save(lmsProfile);
  }

  @Override
  public LmsProfile findById(Integer id) {
    return lmsProfileRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsProfileRepository.deleteById(id);
  }
}
