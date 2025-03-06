package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProfileSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsProfileScheduleService {
  Page<LmsProfileSchedule> findAllPageable(Pageable pageable);
  LmsProfileSchedule save(LmsProfileSchedule profileSchedule);
}
