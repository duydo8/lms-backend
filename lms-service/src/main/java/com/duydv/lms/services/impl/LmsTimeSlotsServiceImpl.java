package com.duydv.lms.services.impl;


import com.duydv.lms.entities.LmsTimeSlots;
import com.duydv.lms.repositories.LmsTimeSlotsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class LmsTimeSlotsServiceImpl implements LmsTimeSlotsService {

  private final LmsTimeSlotsRepository lmsTimeSlotsRepository;

  @Override
  public List<LmsTimeSlots> findAll() {
    return lmsTimeSlotsRepository.findAll();
  }

  @Override
  public LmsTimeSlots findById(int id) {
    return lmsTimeSlotsRepository.findById(id).orElse(null);
  }

  @Override
  public List<LmsTimeSlots> findByIdIn(List<Integer> ids) {
    return lmsTimeSlotsRepository.findByIdIn(ids);
  }

  @Override
  public List<LmsTimeSlots> findByScheduleIdIn(List<Integer> scheduleIds) {
    return lmsTimeSlotsRepository.findByScheduleIdIn(scheduleIds);
  }

  @Override
  public LmsTimeSlots findByDayAndTime(int dayOfWeek, String startTime, String endTime) {
    return lmsTimeSlotsRepository.findByDayAndTime(dayOfWeek, startTime, endTime);
  }

  @Override
  public LmsTimeSlots save(LmsTimeSlots LmsTimeSlots) {
    return lmsTimeSlotsRepository.save(LmsTimeSlots);
  }
}
