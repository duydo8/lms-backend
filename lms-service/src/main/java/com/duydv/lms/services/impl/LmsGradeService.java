package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsGrades;
import java.util.List;
import java.util.Map;

public interface LmsGradeService {

  List<LmsGrades> findAll();

  LmsGrades findById(int parseInt);

  Integer findLevelByGradeId(int gradeId);

  LmsGrades findByLevel(Integer level);

  LmsGrades findByScheduleId(Integer LmsScheduleId);

  Map<Integer, LmsGrades> findAllMap();
}
