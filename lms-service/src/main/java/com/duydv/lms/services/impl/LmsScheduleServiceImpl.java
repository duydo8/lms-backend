package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsSchedules;
import com.duydv.lms.repositories.LmsScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class LmsScheduleServiceImpl implements LmsScheduleService {

  private LmsScheduleRepository lmsScheduleRepository;

  @Override
  public Page<LmsSchedules> findAllPageable(Pageable pageable) {
    return lmsScheduleRepository.findAll(pageable);
  }

  @Override
  public LmsSchedules save(LmsSchedules Schedule) {
    return lmsScheduleRepository.save(Schedule);
  }

  @Override
  public LmsSchedules findById(Integer id) {
    return lmsScheduleRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsScheduleRepository.deleteById(id);
  }
}
