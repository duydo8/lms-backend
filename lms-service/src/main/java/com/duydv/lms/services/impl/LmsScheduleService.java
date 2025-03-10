package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsSchedules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsScheduleService {

  Page<LmsSchedules> findAllPageable(Pageable pageable);

  LmsSchedules save(LmsSchedules lmsSchedules);

  LmsSchedules findById(Integer id);

  void deleteById(Integer id);
}
