package com.duydv.lms.services.impl;


import com.duydv.lms.entities.LmsGrades;
import com.duydv.lms.repositories.LmsGradeRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsGradeServiceImpl implements LmsGradeService {

  private final LmsGradeRepository lmsGradeRepository;

  @Override
  public List<LmsGrades> findAll() {
    return lmsGradeRepository.findAll();
  }

  @Override
  public LmsGrades findById(int id) {
    return lmsGradeRepository.findById(id).orElse(null);
  }

  @Override
  public Integer findLevelByGradeId(int gradeId) {
    return lmsGradeRepository.findLevelByGradeId(gradeId);
  }

  @Override
  public LmsGrades findByLevel(Integer level) {
    return lmsGradeRepository.findByLevel(level);
  }

  @Override
  public LmsGrades findByScheduleId(Integer LmsScheduleId) {
    return lmsGradeRepository.findByScheduleId(LmsScheduleId);
  }

  @Override
  public Map<Integer, LmsGrades> findAllMap() {
    return findAll().stream().collect(Collectors.toMap(LmsGrades::getId, x -> x));
  }
}
