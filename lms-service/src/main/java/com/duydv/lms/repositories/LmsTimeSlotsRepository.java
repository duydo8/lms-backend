package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsTimeSlots;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsTimeSlotsRepository extends JpaRepository<LmsTimeSlots, Integer> {

  List<LmsTimeSlots> findByIdIn(List<Integer> ids);

  @Query("SELECT kts FROM LmsTimeSlots kts " +
      "JOIN LmsScheduleSlots kss ON kts.id = kss.timeSlotId " +
      "WHERE kss.scheduleId IN :scheduleIds")
  List<LmsTimeSlots> findByScheduleIdIn(
      @Param("scheduleIds") List<Integer> scheduleIds);

  @Query("SELECT ts FROM LmsTimeSlots ts WHERE ts.dayOfWeek = ?1 and ts.startTime = ?2 and ts.endTime = ?3")
  LmsTimeSlots findByDayAndTime(int dayOfWeek, String startTime, String endTime);

  @Query(value = "select count(ss.time_slot_id) from educa_Lms.Lms_schedule_slots ss " +
      "join educa_Lms.Lms_schedules s on s.id = ss.schedule_id " +
      "join educa_Lms.Lms_courses c on s.course_id = c.id " +
      "join educa_Lms.Lms_profile_schedule ps on ps.schedule_id = ss.schedule_id " +
      "where s.course_id = ?1 and ps.profile_id = ?2 and ss.time_slot_id in (?3) ", nativeQuery = true)
  Integer countExistByCourseIdAndProfileIdAndTimeSlotId(Integer courseId, Integer profileId,
      List<Integer> timeSlotIds);
}
