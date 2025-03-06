package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsTimeSlots;
import java.util.List;

public interface LmsTimeSlotsService {

  List<LmsTimeSlots> findAll();

  LmsTimeSlots findById(int id);

  List<LmsTimeSlots> findByIdIn(List<Integer> ids);

  List<LmsTimeSlots> findByScheduleIdIn(List<Integer> scheduleIds);

  LmsTimeSlots findByDayAndTime(int dayOfWeek, String startTime, String endTime);

  LmsTimeSlots save(LmsTimeSlots LmsTimeSlots);

}
