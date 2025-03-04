package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsCourses;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsCourseRepository extends JpaRepository<LmsCourses, Integer> {

  @Query(value = "SELECT * FROM educa_Lms.`Lms_courses` o WHERE o.`is_active` = 1 AND o.`deleted_at` IS NULL", nativeQuery = true)
  List<LmsCourses> findAll();

  @Query(value = "SELECT * FROM educa_Lms.`Lms_courses` o WHERE o.`grade_id` = ?1 AND o.`is_active` = 1 AND o.`deleted_at` IS NULL", nativeQuery = true)
  List<LmsCourses> findByGradeId(Integer gradeId);

  @Query(value = "SELECT kc.* FROM educa_Lms.Lms_courses kc \n" +
      "JOIN educa_Lms.Lms_schedules ks ON ks.course_id = kc.id \n" +
      "JOIN educa_Lms.Lms_profile_schedule kps ON kps.schedule_id = ks.id \n" +
      "WHERE kc.subject_id = :subjectId AND kps.profile_id = :profileId LIMIT 1", nativeQuery = true)
  LmsCourses findFirstBySubjectIdAndProfileId(Integer subjectId, Integer profileId);

  List<LmsCourses> findByIdIn(Set<Integer> ids);

  @Query("SELECT kc FROM LmsCourses kc " +
      "JOIN LmsSchedules ks ON ks.courseId = kc.id " +
      "WHERE ks.id = :scheduleId ")
  LmsCourses findByScheduleId(
      @Param("scheduleId") Integer scheduleId);

  LmsCourses findFirstBySubjectIdAndGradeIdAndIsActive(Integer subjectId, Integer gradeId,
      boolean i);

  @Query(value = "SELECT kc.`id` FROM educa_Lms.`Lms_courses`kc WHERE kc.`subject_id` = ?1", nativeQuery = true)
  List<Integer> findIdsBySubjectId(Integer subjectId);
}
