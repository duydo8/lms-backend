package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProfile;
import com.duydv.lms.repositories.LmsProfileRepository;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsProfileServiceImpl implements LmsProfileService {

  private final LmsProfileRepository lmsProfileRepository;

  @Override
  public List<LmsProfile> findByAccountId(int accountId) {
    return lmsProfileRepository.findByAccountId(accountId);
  }

  @Override
  public List<LmsProfile> findByPhone(String phone) {
    return lmsProfileRepository.findByPhone(phone);
  }

  @Override
  public Page<LmsProfile> findByIsVip(Pageable page) {
    return lmsProfileRepository.findByIsVip(1, page);
  }

  @Override
  public LmsProfile findById(int id) {
    return lmsProfileRepository.findById(id).orElse(null);
  }

  @Override
  public LmsProfile findByLmsId(int id) {
    return lmsProfileRepository.findByLmsId(id);
  }

  @Override
  public List<LmsProfile> findAll() {
    return lmsProfileRepository.findAll();
  }

  @Override
  public LmsProfile update(LmsProfile LmsProfile) {
    return lmsProfileRepository.saveAndFlush(LmsProfile);
  }

  @Override
  public String getPhone(int profileId) {
    return lmsProfileRepository.getPhone(profileId);
  }

  @Override
  public Page<LmsProfile> findAll(Pageable page) {
    return lmsProfileRepository.findAll(page);
  }

  @Override
  public LmsProfile create(LmsProfile LmsProfile) {
    return lmsProfileRepository.saveAndFlush(LmsProfile);
  }

  @Override
  public Page<LmsProfile> findByIsPaid(int isPaid, Pageable page) {
    return lmsProfileRepository.findByIsPaid(isPaid, page);
  }

  @Override
  public List<LmsProfile> findByIsPaidOrderByIdDesc(int isPaid) {
    return lmsProfileRepository.findByIsPaidOrderByIdDesc(isPaid);
  }

  @Override
  public List<LmsProfile> findByIdIn(Collection<Integer> profileIds) {
    return lmsProfileRepository.findByIdIn(profileIds);
  }

  @Override
  public Page<LmsProfile> findByGradeId(int gradeId, Pageable pageable) {
    return lmsProfileRepository.findByGradeId(gradeId, pageable);
  }

  @Override
  public Page<LmsProfile> findByStatus(int status, Pageable pageable) {
    return lmsProfileRepository.findByStatus(status, pageable);
  }

  @Override
  public Page<LmsProfile> findByStatusAndIsPaid(int status, int isPaid, Pageable pageable) {
    return lmsProfileRepository.findByStatusAndIsPaid(status, isPaid, pageable);
  }

  @Override
  public List<LmsProfile> findByAccountIdIn(Set<Integer> accountIds) {
    return lmsProfileRepository.findByAccountIdIn(accountIds);
  }
}
