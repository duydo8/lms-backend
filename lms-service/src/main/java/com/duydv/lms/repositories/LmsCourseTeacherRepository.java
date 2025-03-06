package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsCourseTeacher;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsCourseTeacherRepository extends JpaRepository<LmsCourseTeacher, Integer> {

  List<LmsCourseTeacher> findByCourseId(int courseId);

  List<LmsCourseTeacher> findByCourseIdIn(Collection<Integer> courseIds);

  @Query(value = "SELECT o.`course_id` FROM educa_Lms.`Lms_course_teacher` o WHERE o.`teacher_id` = ?1", nativeQuery = true)
  Set<Integer> findCourseIdByTeacherId(int teacherId);
}
