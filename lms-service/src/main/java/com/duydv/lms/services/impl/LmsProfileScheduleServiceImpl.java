package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProfileSchedule;
import com.duydv.lms.repositories.LmsProfileScheduleRepository;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsProfileScheduleServiceImpl implements LmsProfileScheduleService {

  private final LmsProfileScheduleRepository lmsProfileScheduleRepository;

  @Override
  public List<LmsProfileSchedule> findAll() {
    return lmsProfileScheduleRepository.findAll();
  }

  @Override
  public List<Integer> findScheduleIdByProfileId(int profileIds) {
    return lmsProfileScheduleRepository.findScheduleIdByProfileId(profileIds);
  }

  @Override
  public Set<Integer> findCourseIdsFromProfileId(int profileId) {
    return lmsProfileScheduleRepository.findCourseIdsFromProfileId(profileId);
  }

  @Override
  public List<LmsProfileSchedule> findByProfileId(int profileId) {
    return lmsProfileScheduleRepository.findByProfileId(profileId);
  }

  @Override
  public LmsProfileSchedule findByProfileIdAndScheduleId(int profileId, int scheduleId) {
    return lmsProfileScheduleRepository.findByProfileIdAndScheduleId(profileId, scheduleId);
  }

  @Override
  public List<LmsProfileSchedule> findByProfileIdAndSubjectId(int profileId, int subjectId) {
    return lmsProfileScheduleRepository.findByProfileIdAndSubjectId(profileId, subjectId);
  }

  @Transactional
  @Modifying
  @Override
  public LmsProfileSchedule save(LmsProfileSchedule LmsProfileSchedule) {
    return lmsProfileScheduleRepository.saveAndFlush(LmsProfileSchedule);
  }

  @Override
  public void remove(LmsProfileSchedule LmsProfileSchedule) {
    lmsProfileScheduleRepository.delete(LmsProfileSchedule);
  }

  @Override
  public Set<LmsProfileSchedule> findAllProfileIdsByScheduleIdIn(Set<Integer> scheduleIds) {
    if (CollectionUtils.isEmpty(scheduleIds)) {
      return Collections.emptySet();
    }

    return lmsProfileScheduleRepository.findAllProfileIdsByScheduleIdIn(scheduleIds);
  }

  @Override
  public List<LmsProfileSchedule> findByScheduleId(int scheduleId) {
    return lmsProfileScheduleRepository.findByScheduleId(scheduleId);
  }

  @Override
  public Set<Integer> findProfileIdByProfileIdInAndScheduleIdIn(Set<Integer> profileIds,
      List<Integer> scheduleIds) {
    return lmsProfileScheduleRepository.findProfileIdByProfileIdInAndScheduleIdIn(profileIds,
        scheduleIds);
  }

  @Override
  public List<LmsProfileSchedule> findByGroupIdAndProfileIdIn(int groupId, int profileId) {
    return lmsProfileScheduleRepository.findByGroupIdAndProfileIdIn(groupId, profileId);
  }

  @Override
  public List<Integer> getScheduleIdsByProfileIdAndTypeAndCourseId(Integer profileId, Integer type,
      Integer courseId) {
    return lmsProfileScheduleRepository.getScheduleIdsByProfileIdAndTypeAndCourseId(profileId, type,
        courseId);
  }

  @Override
  public void removeAllProfileScheduleInCenterSchedule(int profileId, List<Integer> scheduleIds) {
    lmsProfileScheduleRepository.removeAllProfileScheduleInCenterSchedule(profileId,
        scheduleIds);
  }

  @Override
  public List<LmsProfileSchedule> saveAll(List<LmsProfileSchedule> LmsProfileSchedules) {
    return lmsProfileScheduleRepository.saveAll(LmsProfileSchedules);
  }
}
