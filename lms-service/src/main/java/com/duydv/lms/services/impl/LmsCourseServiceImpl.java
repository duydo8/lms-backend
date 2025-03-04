package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsCourses;
import com.duydv.lms.repositories.LmsCourseRepository;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsCourseServiceImpl implements LmsCourseService {

  private final LmsCourseRepository lmsCourseRepository;

  @Override
  public List<LmsCourses> findAll() {
    return lmsCourseRepository.findAll();
  }

  @Override
  public LmsCourses findById(int id) {
    return lmsCourseRepository.findById(id).orElse(null);
  }

  @Override
  public LmsCourses save(LmsCourses LmsCourse) {
    return lmsCourseRepository.save(LmsCourse);
  }

  @Override
  public LmsCourses findByScheduleId(Integer scheduleId) {
    return lmsCourseRepository.findByScheduleId(scheduleId);
  }

  @Override
  public List<LmsCourses> findByGradeId(Integer gradeId) {
    return lmsCourseRepository.findByGradeId(gradeId);
  }

  @Override
  public LmsCourses findFirstBySubjectIdAndProfileId(
      Integer subjectId,
      Integer profileId
  ) {
    return lmsCourseRepository.findFirstBySubjectIdAndProfileId(
        subjectId,
        profileId
    );
  }

  @Override
  public LmsCourses findBySubjectIdAndGradeId(Integer subjectId, Integer gradeId) {
    return lmsCourseRepository.findFirstBySubjectIdAndGradeIdAndIsActive(subjectId, gradeId, true);
  }

  @Override
  public List<LmsCourses> findByIdIn(Set<Integer> ids) {
    return lmsCourseRepository.findByIdIn(ids);
  }

  @Override
  public List<Integer> findIdsBySubjectId(Integer subjectId) {
    return lmsCourseRepository.findIdsBySubjectId(subjectId);
  }
}
