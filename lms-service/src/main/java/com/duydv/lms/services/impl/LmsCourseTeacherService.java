package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsCourseTeacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsCourseTeacherService {

  Page<LmsCourseTeacher> findAllPageable(Pageable pageable);

  LmsCourseTeacher save(LmsCourseTeacher courseTeacher);

  LmsCourseTeacher findById(Integer id);

  void deleteById(Integer id);
}
