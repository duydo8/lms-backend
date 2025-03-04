package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsCourses;
import java.util.List;
import java.util.Set;

public interface LmsCourseService {

  List<LmsCourses> findAll();

  LmsCourses findById(int id);

  LmsCourses save(LmsCourses LmsCourse);

  LmsCourses findByScheduleId(Integer scheduleId);

  List<LmsCourses> findByGradeId(Integer gradeId);

  LmsCourses findFirstBySubjectIdAndProfileId(Integer subjectId, Integer profileId);

  LmsCourses findBySubjectIdAndGradeId(Integer subjectId, Integer gradeId);

  List<LmsCourses> findByIdIn(Set<Integer> ids);

  List<Integer> findIdsBySubjectId(Integer subjectId);
}
