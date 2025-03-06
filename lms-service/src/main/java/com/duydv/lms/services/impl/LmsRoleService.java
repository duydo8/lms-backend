package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsRoles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsRoleService {

  Page<LmsRoles> findAllPageable(Pageable pageable);

  LmsRoles save(LmsRoles roles);

  LmsRoles findById(Integer id);

  void deleteById(Integer id);
}
