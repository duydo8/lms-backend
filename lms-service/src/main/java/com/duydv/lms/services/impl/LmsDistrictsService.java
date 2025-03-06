package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsDistricts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsDistrictsService {

  Page<LmsDistricts> findAllPageable(Pageable pageable);

  LmsDistricts save(LmsDistricts District);

  LmsDistricts findById(Integer id);

  void deleteById(Integer id);
}
