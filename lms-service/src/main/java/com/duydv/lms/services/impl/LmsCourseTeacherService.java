package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsCourseTeacher;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface LmsCourseTeacherService {

  List<LmsCourseTeacher> findByCourseId(int courseId);

  List<LmsCourseTeacher> findByCourseIds(Collection<Integer> courseIds);

  List<LmsCourseTeacher> findAll();

  Set<Integer> findCourseIdByTeacherId(int teacherId);
}
