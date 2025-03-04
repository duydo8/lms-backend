package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProfileSchedule;
import java.util.List;
import java.util.Set;

public interface LmsProfileScheduleService {

  List<LmsProfileSchedule> findAll();

  List<Integer> findScheduleIdByProfileId(int profileIds);

  Set<Integer> findCourseIdsFromProfileId(int profileId);

  List<LmsProfileSchedule> findByProfileId(int profileId);

  LmsProfileSchedule findByProfileIdAndScheduleId(int profileId, int scheduleId);

  List<LmsProfileSchedule> findByProfileIdAndSubjectId(int profileId, int subjectId);

  LmsProfileSchedule save(LmsProfileSchedule LmsProfileSchedule);

  void remove(LmsProfileSchedule LmsProfileSchedule);

  Set<LmsProfileSchedule> findAllProfileIdsByScheduleIdIn(Set<Integer> scheduleIds);

  List<LmsProfileSchedule> findByScheduleId(int scheduleId);

  Set<Integer> findProfileIdByProfileIdInAndScheduleIdIn(Set<Integer> profileIds,
      List<Integer> scheduleIds);

  List<LmsProfileSchedule> findByGroupIdAndProfileIdIn(int groupId, int profileId);

  List<Integer> getScheduleIdsByProfileIdAndTypeAndCourseId(Integer profileId, Integer type,
      Integer courseId);

  void removeAllProfileScheduleInCenterSchedule(int profileId, List<Integer> scheduleIds);

  List<LmsProfileSchedule> saveAll(List<LmsProfileSchedule> LmsProfileSchedules);
}
