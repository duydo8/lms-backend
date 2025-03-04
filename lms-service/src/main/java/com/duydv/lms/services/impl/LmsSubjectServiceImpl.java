package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsSubject;
import com.duydv.lms.repositories.LmsSubjectRepository;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class LmsSubjectServiceImpl implements LmsSubjectService {

  private final LmsSubjectRepository lmsSubjectRepository;

  @Override
  public List<LmsSubject> findAll() {
    return lmsSubjectRepository.findAllIsActive();
  }

  @Override
  public LmsSubject findById(int id) {
    return lmsSubjectRepository.findIsActiveById(id);
  }

  @Override
  public void deleteById(int id) {
    lmsSubjectRepository.deleteById(id);
  }

  @Override
  public LmsSubject update(LmsSubject lmsSubject) {
    if (lmsSubjectRepository.findById(lmsSubject.getId()).isPresent()) {
      lmsSubject.setUpdatedAt(new Date());
      return lmsSubjectRepository.save(lmsSubject);
    }
    return null;
  }

  @Override
  public LmsSubject save(LmsSubject lmsSubject) {
    lmsSubject.setIsActive(true);
    lmsSubject.setCreatedAt(new Date());
    lmsSubject.setUpdatedAt(new Date());
    lmsSubject.setDeletedAt(null);
    return lmsSubjectRepository.save(lmsSubject);
  }

  @Override
  public LmsSubject findByName(String name) {
    return lmsSubjectRepository.findByName(name);
  }

  @Override
  public List<LmsSubject> findLikeName(String name) {
    return lmsSubjectRepository.findLikeName("%" + name + "%");
  }
}
