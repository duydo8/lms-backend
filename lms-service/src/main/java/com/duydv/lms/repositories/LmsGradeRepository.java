package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsGrades;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsGradeRepository extends JpaRepository<LmsGrades, Integer> {

  @Query(value = "SELECT * FROM educa_Lms.`Lms_grades` o WHERE o.`is_active` = 1 AND o.`deleted_at` IS NULL", nativeQuery = true)
  List<LmsGrades> findAll();

  @Query(value = "SELECT o.`level` FROM educa_Lms.`Lms_grades` o WHERE o.`id` = ?1", nativeQuery = true)
  Integer findLevelByGradeId(int gradeId);

  @Query(value = "SELECT * FROM educa_Lms.`Lms_grades` o WHERE o.`is_active` = 1 AND o.`deleted_at` IS NULL AND level = ?1", nativeQuery = true)
  LmsGrades findByLevel(Integer level);

  @Query(value = "SELECT * FROM educa_Lms.`Lms_grades` WHERE id = (SELECT kc.`grade_id` FROM educa_Lms.`Lms_courses` kc WHERE kc.`id` = (SELECT ks.`course_id` FROM educa_Lms.`Lms_schedules` ks WHERE ks.`id` = ?1))", nativeQuery = true)
  LmsGrades findByScheduleId(Integer LmsScheduleId);
}
