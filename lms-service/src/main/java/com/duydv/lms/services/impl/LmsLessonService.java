package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsLessons;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsLessonService {

  Page<LmsLessons> findAllPageable(Pageable pageable);

  LmsLessons save(LmsLessons lessons);

  LmsLessons findById(Integer id);

  void deleteById(Integer id);
}
