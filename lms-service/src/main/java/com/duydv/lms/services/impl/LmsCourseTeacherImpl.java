package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsCourseTeacher;
import com.duydv.lms.repositories.LmsCourseTeacherRepository;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsCourseTeacherImpl implements LmsCourseTeacherService {

  private final LmsCourseTeacherRepository lmsCourseTeacherRepository;

  @Override
  public List<LmsCourseTeacher> findByCourseId(int courseId) {
    return lmsCourseTeacherRepository.findByCourseId(courseId);
  }

  @Override
  public List<LmsCourseTeacher> findByCourseIds(Collection<Integer> courseIds) {
    if (CollectionUtils.isEmpty(courseIds)) {
      return Collections.emptyList();
    }
    return lmsCourseTeacherRepository.findByCourseIdIn(courseIds);
  }

  @Override
  public List<LmsCourseTeacher> findAll() {
    return lmsCourseTeacherRepository.findAll();
  }

  @Override
  public Set<Integer> findCourseIdByTeacherId(int teacherId) {
    return lmsCourseTeacherRepository.findCourseIdByTeacherId(teacherId);
  }
}
