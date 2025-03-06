package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsScheduleSlots;
import com.duydv.lms.entities.LmsScheduleSlotsPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LmsScheduleSlotsRepository extends
    JpaRepository<LmsScheduleSlots, LmsScheduleSlotsPK> {

  @Query(value = "SELECT o.time_slot_id FROM educa_Lms.Lms_schedule_slots o WHERE o.schedule_id = ?1", nativeQuery = true)
  List<Integer> findTimeSlotIdByScheduleId(int scheduleId);

  @Query("SELECT ss FROM LmsScheduleSlots ss WHERE ss.scheduleId = ?1 and ss.timeSlotId = ?2")
  LmsScheduleSlots findById(Integer scheduleId, Integer timeSlotId);
}
