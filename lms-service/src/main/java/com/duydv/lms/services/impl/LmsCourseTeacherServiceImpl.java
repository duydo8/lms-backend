package com.duydv.lms.services.impl;


import com.duydv.lms.entities.LmsCourseTeacher;
import com.duydv.lms.repositories.LmsCourseTeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsCourseTeacherServiceImpl implements LmsCourseTeacherService {

  private final LmsCourseTeacherRepository lmsCourseTeachersRepository;

  @Override
  public Page<LmsCourseTeacher> findAllPageable(Pageable pageable) {
    return lmsCourseTeachersRepository.findAll(pageable);
  }

  @Override
  public LmsCourseTeacher save(LmsCourseTeacher lmsCourseTeacher) {
    return lmsCourseTeachersRepository.save(lmsCourseTeacher);
  }

  @Override
  public LmsCourseTeacher findById(Integer id) {
    return lmsCourseTeachersRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsCourseTeachersRepository.deleteById(id);
  }
}
