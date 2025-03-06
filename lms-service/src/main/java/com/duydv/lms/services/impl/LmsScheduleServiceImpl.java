package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsSchedules;
import com.duydv.lms.repositories.LmsScheduleRepository;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class LmsScheduleServiceImpl implements LmsScheduleService {

  private final LmsScheduleRepository lmsScheduleRepository;

  @Override
  public LmsSchedules findById(Integer id) {
    var lmsSchedules = lmsScheduleRepository.findById(id);
    return lmsSchedules.orElse(null);
  }

  @Override
  public List<LmsSchedules> findAll() {
    return lmsScheduleRepository.findAll();
  }

  @Override
  public List<LmsSchedules> findByCourseId(int courseId) {
    return lmsScheduleRepository.findByCourseId(courseId);
  }

  @Override
  public List<LmsSchedules> findByCourseIdAndParentIdIsNotNull(int courseId) {
    return lmsScheduleRepository.findByCourseIdAndParentIdIsNotNull(courseId);
  }

  @Override
  public List<LmsSchedules> findByCourseIds(Collection<Integer> courseIds) {
    return lmsScheduleRepository.findByCourseIdIn(courseIds);
  }

  @Override
  public List<LmsSchedules> findByProfileId(Integer profileId) {
    return lmsScheduleRepository.findByProfileId(profileId);
  }

  @Override
  public LmsSchedules findByProfileIdAndSubjectId(Integer profileId, Integer subjectId) {
    return lmsScheduleRepository.findByProfileIdAndSubjectId(profileId, subjectId);
  }

  @Override
  public LmsSchedules save(LmsSchedules LmsSchedule) {
    return lmsScheduleRepository.save(LmsSchedule);
  }

  @Override
  public List<LmsSchedules> findByIdIn(List<Integer> ids) {
    return lmsScheduleRepository.findByIdIn(ids);
  }

  @Override
  public List<Integer> findIdsByCourseId(int courseId) {
    return lmsScheduleRepository.findIdsByCourseId(courseId);
  }

  @Override
  public List<Integer> findIdsByCourseIdIn(List<Integer> courseIds) {
    return lmsScheduleRepository.findIdsByCourseIdIn(courseIds);
  }

  @Override
  public List<LmsSchedules> findScheduleIdByCourseIdAndListTimeSlotId(Integer courseId,
      Integer type, List<Integer> timeSlotIds) {
    return lmsScheduleRepository.findScheduleIdByCourseIdAndListTimeSlotId(courseId, type,
        timeSlotIds, timeSlotIds.size());
  }
}
