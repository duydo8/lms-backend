package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsSchools;
import com.duydv.lms.repositories.LmsSchoolsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LmsSchoolsServiceImpl implements LmsSchoolsService {

  private final LmsSchoolsRepository lmsSchoolsRepository;

  @Override
  public Page<LmsSchools> findAllPageable(Pageable pageable) {
    return lmsSchoolsRepository.findAll(pageable);
  }

  @Override
  public LmsSchools save(LmsSchools lmsSchools) {
    return lmsSchoolsRepository.save(lmsSchools);
  }

  @Override
  public LmsSchools findById(Integer id) {
    return lmsSchoolsRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsSchoolsRepository.deleteById(id);
  }
}
