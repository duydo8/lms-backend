package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsLessons;
import com.duydv.lms.repositories.LmsLessonRepository;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsLessonServiceImpl implements LmsLessonService {

  private final LmsLessonRepository lmsLessonRepository;

  @Override
  public List<LmsLessons> findAll() {
    return lmsLessonRepository.findAll();
  }

  @Override
  public LmsLessons findById(Integer id) {
    return lmsLessonRepository.findById(id).orElse(null);
  }

  @Override
  public List<LmsLessons> findByStageIdIn(Set<Integer> stageIds) {
    if (CollectionUtils.isEmpty(stageIds)) {
      return Collections.emptyList();
    }
    return lmsLessonRepository.findByStageIdIn(stageIds);
  }

  @Override
  public List<LmsLessons> findByIds(Collection<Integer> ids) {
    if (CollectionUtils.isEmpty(ids)) {
      return Collections.emptyList();
    }
    return lmsLessonRepository.findByIdIn(ids);
  }
}
