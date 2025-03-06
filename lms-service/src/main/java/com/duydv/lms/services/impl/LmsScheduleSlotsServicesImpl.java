package com.duydv.lms.services.impl;


import com.duydv.lms.entities.LmsScheduleSlots;
import com.duydv.lms.repositories.LmsScheduleSlotsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsScheduleSlotsServicesImpl implements LmsScheduleSlotsService {

  private LmsScheduleSlotsRepository lmsScheduleSlotsRepository;

  @Override
  public Page<LmsScheduleSlots> findAllPageable(Pageable pageable) {
    return lmsScheduleSlotsRepository.findAll(pageable);
  }

  @Override
  public LmsScheduleSlots save(LmsScheduleSlots lmsScheduleSlots) {
    return lmsScheduleSlotsRepository.save(lmsScheduleSlots);
  }
}
