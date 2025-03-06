package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProfileSchedule;
import com.duydv.lms.repositories.LmsProfileScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsProfileScheduleServiceImpl implements LmsProfileScheduleService {

  private LmsProfileScheduleRepository lmsProfileScheduleRepository;

  @Override
  public Page<LmsProfileSchedule> findAllPageable(Pageable pageable) {
    return lmsProfileScheduleRepository.findAll(pageable);
  }

  @Override
  public LmsProfileSchedule save(LmsProfileSchedule profileSchedule) {
    return lmsProfileScheduleRepository.save(profileSchedule);
  }
}
