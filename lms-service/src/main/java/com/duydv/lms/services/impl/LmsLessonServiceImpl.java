package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsLessons;
import com.duydv.lms.repositories.LmsLessonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsLessonServiceImpl implements LmsLessonService {

  private LmsLessonRepository lmsLessonRepository;

  @Override
  public Page<LmsLessons> findAllPageable(Pageable pageable) {
    return lmsLessonRepository.findAll(pageable);
  }

  @Override
  public LmsLessons save(LmsLessons lessons) {
    return lmsLessonRepository.save(lessons);
  }

  @Override
  public LmsLessons findById(Integer id) {
    return lmsLessonRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsLessonRepository.deleteById(id);
  }
}
