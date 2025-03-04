package com.duydv.lms.services.impl;


import com.duydv.lms.entities.LmsScheduleSlots;
import com.duydv.lms.repositories.LmsScheduleSlotsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsScheduleSlotsServicesImpl implements LmsScheduleSlotsServices {

  private final LmsScheduleSlotsRepository lmsScheduleSlotsRepository;

  @Override
  public List<Integer> findTimeSlotIdByScheduleId(int scheduleId) {
    return lmsScheduleSlotsRepository.findTimeSlotIdByScheduleId(scheduleId);
  }

  @Override
  public List<LmsScheduleSlots> findAll() {
    return lmsScheduleSlotsRepository.findAll();
  }

  @Override
  public LmsScheduleSlots save(LmsScheduleSlots LmsScheduleSlots) {
    return lmsScheduleSlotsRepository.save(LmsScheduleSlots);
  }

  @Override
  public LmsScheduleSlots findById(Integer scheduleId, Integer timeSlotId) {
    return lmsScheduleSlotsRepository.findById(scheduleId, timeSlotId);
  }
}
