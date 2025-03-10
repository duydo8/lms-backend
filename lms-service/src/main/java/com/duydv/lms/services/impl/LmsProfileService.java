package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsProfileService {

  Page<LmsProfile> findAllPageable(Pageable pageable);

  LmsProfile save(LmsProfile p);

  LmsProfile findById(Integer id);

  void deleteById(Integer id);
}
