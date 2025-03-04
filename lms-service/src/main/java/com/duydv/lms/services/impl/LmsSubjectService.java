package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsSubject;
import java.util.List;

public interface LmsSubjectService {

  List<LmsSubject> findAll();

  LmsSubject findById(int id);

  void deleteById(int id);

  LmsSubject update(LmsSubject lmsSubject);

  LmsSubject save(LmsSubject lmsSubject);

  LmsSubject findByName(String name);

  List<LmsSubject> findLikeName(String name);
}
