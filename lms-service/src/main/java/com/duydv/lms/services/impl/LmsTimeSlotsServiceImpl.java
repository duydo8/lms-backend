package com.duydv.lms.services.impl;


import com.duydv.lms.entities.LmsTimeSlots;
import com.duydv.lms.repositories.LmsTimeSlotsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class LmsTimeSlotsServiceImpl implements LmsTimeSlotsService {

  private LmsTimeSlotsRepository lmsTimeSlotsRepository;

  @Override
  public Page<LmsTimeSlots> findAllPageable(Pageable pageable) {
    return lmsTimeSlotsRepository.findAll(pageable);
  }

  @Override
  public LmsTimeSlots save(LmsTimeSlots TimeSlots) {
    return lmsTimeSlotsRepository.save(TimeSlots);
  }

  @Override
  public LmsTimeSlots findById(Integer id) {
    return lmsTimeSlotsRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsTimeSlotsRepository.deleteById(id);
  }
}
