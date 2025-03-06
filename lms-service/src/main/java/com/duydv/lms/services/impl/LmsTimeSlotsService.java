package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsTimeSlots;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsTimeSlotsService {

  Page<LmsTimeSlots> findAllPageable(Pageable pageable);

  LmsTimeSlots save(LmsTimeSlots lmsTimeSlots);

  LmsTimeSlots findById(Integer id);

  void deleteById(Integer id);

}
