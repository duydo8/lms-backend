package com.duydv.lms.services.impl;


import com.duydv.lms.entities.LmsGrades;
import com.duydv.lms.repositories.LmsGradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsGradeServiceImpl implements LmsGradeService {

  private LmsGradeRepository lmsGradesRepository;

  @Override
  public Page<LmsGrades> findAllPageable(Pageable pageable) {
    return lmsGradesRepository.findAll(pageable);
  }

  @Override
  public LmsGrades save(LmsGrades grades) {
    return lmsGradesRepository.save(grades);
  }

  @Override
  public LmsGrades findById(Integer id) {
    return lmsGradesRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsGradesRepository.deleteById(id);
  }
}
