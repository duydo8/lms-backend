package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsSchedules;
import java.util.Collection;
import java.util.List;

public interface LmsScheduleService {

  LmsSchedules findById(Integer id);

  List<LmsSchedules> findAll();

  List<LmsSchedules> findByCourseId(int courseId);

  List<LmsSchedules> findByCourseIdAndParentIdIsNotNull(int courseId);

  List<LmsSchedules> findByCourseIds(Collection<Integer> courseIds);

  List<LmsSchedules> findByProfileId(Integer profileId);

  LmsSchedules findByProfileIdAndSubjectId(
      Integer profileId,
      Integer subjectId
  );

  LmsSchedules save(LmsSchedules LmsSchedule);

  List<LmsSchedules> findByIdIn(List<Integer> ids);

  List<Integer> findIdsByCourseId(int courseId);

  List<Integer> findIdsByCourseIdIn(List<Integer> courseIds);

  List<LmsSchedules> findScheduleIdByCourseIdAndListTimeSlotId(Integer courseId, Integer type,
      List<Integer> timeSlotIds);
}
