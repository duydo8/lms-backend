package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsCourses;
import com.duydv.lms.repositories.LmsCourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsCourseServiceImpl implements LmsCourseService {

  private final LmsCourseRepository lmsCoursesRepository;

  @Override
  public Page<LmsCourses> findAllPageable(Pageable pageable) {
    return lmsCoursesRepository.findAll(pageable);
  }

  @Override
  public LmsCourses save(LmsCourses courses) {
    return lmsCoursesRepository.save(courses);
  }

  @Override
  public LmsCourses findById(Integer id) {
    return lmsCoursesRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsCoursesRepository.deleteById(id);
  }
}
