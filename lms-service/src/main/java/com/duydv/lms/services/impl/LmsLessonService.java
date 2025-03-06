package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsLessons;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface LmsLessonService {

  List<LmsLessons> findAll();

  LmsLessons findById(Integer id);

  List<LmsLessons> findByStageIdIn(Set<Integer> stageIds);

  List<LmsLessons> findByIds(Collection<Integer> ids);
}
