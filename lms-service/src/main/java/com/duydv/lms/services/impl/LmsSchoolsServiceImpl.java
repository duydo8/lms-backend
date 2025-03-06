package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsSchools;
import com.duydv.lms.repositories.LmsSchoolsRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LmsSchoolsServiceImpl implements LmsSchoolsService {

  private final LmsSchoolsRepository lmsSchoolsRepository;

  public LmsSchoolsServiceImpl(
      LmsSchoolsRepository lmsSchoolsRepository
  ) {
    this.lmsSchoolsRepository = lmsSchoolsRepository;
  }

  @Override
  public List<LmsSchools> findByDistrictCode(Integer code) {
//        return LmsSchoolsRepository.findByDistrictCode(code);
    return null;
  }

  @Override
  public List<LmsSchools> findByDistrictId(Integer distId) {
    return lmsSchoolsRepository.findByDistrictId(distId);
  }

  @Override
  public LmsSchools findById(int i) {
    return lmsSchoolsRepository.findById(i).orElse(null);
  }
}
