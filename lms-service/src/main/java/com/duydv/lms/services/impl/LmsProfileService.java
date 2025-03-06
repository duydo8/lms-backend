package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProfile;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsProfileService {

  List<LmsProfile> findByAccountId(int accountId);

  List<LmsProfile> findByPhone(String phone);

  Page<LmsProfile> findByIsVip(Pageable page);

  LmsProfile findById(int id);

  LmsProfile findByLmsId(int id);

  List<LmsProfile> findAll();

  LmsProfile update(LmsProfile LmsProfile);

  String getPhone(int profileId);

  Page<LmsProfile> findAll(Pageable page);

  LmsProfile create(LmsProfile LmsProfile);

  Page<LmsProfile> findByIsPaid(int isPaid, Pageable page);

  Page<LmsProfile> findByStatus(int status, Pageable page);

  Page<LmsProfile> findByStatusAndIsPaid(int status, int isPaid, Pageable page);

  List<LmsProfile> findByIdIn(Collection<Integer> profileIds);

  Page<LmsProfile> findByGradeId(int gradeId, Pageable pageable);

  List<LmsProfile> findByAccountIdIn(Set<Integer> accountIds);

  List<LmsProfile> findByIsPaidOrderByIdDesc(int isPaid);
}
