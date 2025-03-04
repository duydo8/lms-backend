package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsScheduleSlots;
import java.util.List;

public interface LmsScheduleSlotsServices {

  List<Integer> findTimeSlotIdByScheduleId(int scheduleId);

  List<LmsScheduleSlots> findAll();

  LmsScheduleSlots save(LmsScheduleSlots LmsScheduleSlots);

  LmsScheduleSlots findById(Integer scheduleId, Integer timeSlotId);
}
