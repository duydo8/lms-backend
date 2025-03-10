package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProvinces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsProvincesService {

  Page<LmsProvinces> findAllPageable(Pageable pageable);

  LmsProvinces save(LmsProvinces provinces);

  LmsProvinces findById(Integer id);

  void deleteById(Integer id);
}
