package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsGrades;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsGradeService {

  Page<LmsGrades> findAllPageable(Pageable pageable);

  LmsGrades save(LmsGrades grades);

  LmsGrades findById(Integer id);

  void deleteById(Integer id);
}
