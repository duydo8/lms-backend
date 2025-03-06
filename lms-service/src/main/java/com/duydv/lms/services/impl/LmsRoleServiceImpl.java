package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsRoles;
import com.duydv.lms.repositories.LmsRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LmsRoleServiceImpl implements LmsRoleService {

  private LmsRoleRepository lmsRoleRepository;

  @Override
  public Page<LmsRoles> findAllPageable(Pageable pageable) {
    return lmsRoleRepository.findAll(pageable);
  }

  @Override
  public LmsRoles save(LmsRoles lmsRoles) {
    return lmsRoleRepository.save(lmsRoles);
  }

  @Override
  public LmsRoles findById(Integer id) {
    return lmsRoleRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsRoleRepository.deleteById(id);
  }
}
