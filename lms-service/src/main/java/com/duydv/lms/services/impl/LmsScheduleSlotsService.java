package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsScheduleSlots;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsScheduleSlotsService {

  Page<LmsScheduleSlots> findAllPageable(Pageable pageable);

  LmsScheduleSlots save(LmsScheduleSlots lmsScheduleSlots);
}
