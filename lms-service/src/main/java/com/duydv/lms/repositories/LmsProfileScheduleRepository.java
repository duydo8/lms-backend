package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsProfileSchedule;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LmsProfileScheduleRepository extends JpaRepository<LmsProfileSchedule, Integer> {

  LmsProfileSchedule findByProfileIdAndScheduleId(
      Integer profileId,
      Integer scheduleId
  );

  @Query("SELECT kps FROM LmsProfileSchedule kps " +
      "JOIN LmsSchedules ks ON ks.id = kps.scheduleId " +
      "JOIN LmsCourses kc ON kc.id = ks.courseId " +
      "WHERE kc.subjectId = :subjectId AND kps.profileId = :profileId ")
  List<LmsProfileSchedule> findByProfileIdAndSubjectId(
      @Param("profileId") Integer profileId,
      @Param("subjectId") Integer subjectId
  );

  @Query(value = "SELECT s.`schedule_id` FROM educa_Lms.`Lms_profile_schedule` s WHERE s.`profile_id` = ?1", nativeQuery = true)
  List<Integer> findScheduleIdByProfileId(int profileIds);

  @Query(value = "SELECT s.`course_id`\n" +
      "FROM educa_Lms.`Lms_schedules` s\n" +
      "WHERE s.`id` IN (\n" +
      "\tSELECT p.`schedule_id`\n" +
      "\tFROM educa_Lms.`Lms_profile_schedule` p\n" +
      "\tWHERE p.`profile_id` = ?1\n" +
      ")", nativeQuery = true)
  Set<Integer> findCourseIdsFromProfileId(int profileId);

  List<LmsProfileSchedule> findByProfileId(int profileId);

  @Query(value = "SELECT * FROM educa_Lms.`Lms_profile_schedule` s WHERE s.`schedule_id` IN ?1", nativeQuery = true)
  Set<LmsProfileSchedule> findAllProfileIdsByScheduleIdIn(Set<Integer> scheduleIds);

  List<LmsProfileSchedule> findByScheduleId(int scheduleId);

  @Query(value = "SELECT kps.`profile_id` FROM educa_Lms.`Lms_profile_schedule` kps WHERE kps.`profile_id` IN ?1 AND kps.`schedule_id` IN ?2", nativeQuery = true)
  Set<Integer> findProfileIdByProfileIdInAndScheduleIdIn(Set<Integer> profileIds,
      List<Integer> scheduleIds);

  @Query(value = "select * from educa_Lms.Lms_profile_schedule kps \n" +
      "join  educa_Lms_lms.lms_sessions ls on ls.Lms_schedule_id = kps.schedule_id \n" +
      "where ls.session_parent_id = ?1 and profile_id = ?2", nativeQuery = true)
  List<LmsProfileSchedule> findByGroupIdAndProfileIdIn(int groupId, int profileId);

  @Query(
      "SELECT ps.scheduleId FROM LmsProfileSchedule ps JOIN LmsProfile p ON ps.profileId = p.id "
          + "JOIN LmsSchedules s ON s.id = ps.scheduleId "
          + "JOIN LmsCourses c on s.courseId = c.id "
          + "WHERE ps.profileId = ?1 AND s.type = ?2 AND c.id = ?3")
  List<Integer> getScheduleIdsByProfileIdAndTypeAndCourseId(Integer profileId, Integer type,
      Integer courseId);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM LmsProfileSchedule ps WHERE ps.profileId = ?1 AND ps.scheduleId IN (?2)")
  void removeAllProfileScheduleInCenterSchedule(int profileId, List<Integer> scheduleIds);
}
