package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsSchools;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsSchoolsService {

  Page<LmsSchools> findAllPageable(Pageable pageable);

  LmsSchools save(LmsSchools lmsSchools);

  LmsSchools findById(Integer id);

  void deleteById(Integer id);
}
