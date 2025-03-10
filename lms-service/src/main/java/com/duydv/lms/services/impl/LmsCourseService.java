package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsCourses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsCourseService {

  Page<LmsCourses> findAllPageable(Pageable pageable);
  LmsCourses save(LmsCourses courses);
  LmsCourses findById(Integer id);
  void deleteById(Integer id);
}
