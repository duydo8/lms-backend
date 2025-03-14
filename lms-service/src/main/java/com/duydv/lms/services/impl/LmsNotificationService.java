package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsNotificationService {

  Page<LmsNotification> findAllPageable(Pageable pageable);
  LmsNotification save(LmsNotification notification);
  LmsNotification findById(Integer id);
  void deleteById(Integer id);
}
