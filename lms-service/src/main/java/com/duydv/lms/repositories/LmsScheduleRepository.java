package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsSchedules;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LmsScheduleRepository extends JpaRepository<LmsSchedules, Integer> {

  @Query(value = "SELECT * FROM educa_Lms.`Lms_schedules` o WHERE o.`is_active` = 1 AND o.`deleted_at` IS NULL", nativeQuery = true)
  List<LmsSchedules> findAll();

  @Query(value = "SELECT * FROM educa_Lms.`Lms_schedules` s WHERE s.`course_id` = ?1 AND s.`is_active` = 1 AND s.`deleted_at` IS NULL", nativeQuery = true)
  List<LmsSchedules> findByCourseId(int courseId);

  @Query(value = "SELECT * FROM educa_Lms.`Lms_schedules` s " +
      "WHERE s.`course_id` = ?1 " +
      "AND s.`is_active` = 1 " +
      "AND s.`deleted_at` IS NULL " +
      "AND s.parent_id IS NOT NULL", nativeQuery = true)
  List<LmsSchedules> findByCourseIdAndParentIdIsNotNull(int courseId);

  @Query(value = "SELECT * FROM educa_Lms.`Lms_schedules` s WHERE s.`course_id` IN ?1 AND s.`is_active` = 1 AND s.`deleted_at` IS NULL", nativeQuery = true)
  List<LmsSchedules> findByCourseIdIn(Collection<Integer> courseIds);

  @Query(value = "SELECT ks FROM LmsSchedules ks " +
      "JOIN LmsProfileSchedule kps ON ks.id = kps.profileId " +
      "WHERE kps.profileId = :profileId")
  List<LmsSchedules> findByProfileId(@Param("profileId") Integer profileId);

  @Query(value = "SELECT ks FROM LmsSchedules ks " +
      "JOIN LmsProfileSchedule kps ON ks.id = kps.scheduleId " +
      "JOIN LmsCourses kc ON kc.id = ks.courseId " +
      "WHERE kps.profileId = :profileId AND kc.subjectId = :subjectId")
  LmsSchedules findByProfileIdAndSubjectId(
      @Param("profileId") Integer profileId,
      @Param("subjectId") Integer subjectId
  );

  List<LmsSchedules> findByIdIn(List<Integer> ids);

  @Query(value = "SELECT id FROM educa_Lms.`Lms_schedules` ks WHERE ks.`course_id` = ?1", nativeQuery = true)
  List<Integer> findIdsByCourseId(int courseId);

  @Query(value = "SELECT id FROM educa_Lms.`Lms_schedules` ks WHERE ks.`course_id` IN ?1", nativeQuery = true)
  List<Integer> findIdsByCourseIdIn(List<Integer> courseIds);

  @Query(value = "SELECT ks.* FROM Lms_schedules ks "
      + "JOIN Lms_schedule_slots kss ON ks.id = kss.schedule_id "
      + "WHERE ks.course_id = ?1 AND ks.type = ?2 "
      + "GROUP BY ks.id "
      + "HAVING  COUNT(DISTINCT CASE WHEN kss.time_slot_id IN (?3) THEN kss.time_slot_id END) = ?4 "
      + "    AND COUNT(DISTINCT kss.time_slot_id) = ?4", nativeQuery = true)
  List<LmsSchedules> findScheduleIdByCourseIdAndListTimeSlotId(Integer courseId, Integer type,
      List<Integer> timeSlotIds, Integer count);
}
