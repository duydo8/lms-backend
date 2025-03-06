package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsNotification;
import com.duydv.lms.repositories.LmsNotificationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class LmsNotificationServiceImpl implements LmsNotificationService {

  private LmsNotificationRepository lmsNotificationRepository;

  @Override
  public Page<LmsNotification> findAllPageable(Pageable pageable) {
    return lmsNotificationRepository.findAll(pageable);
  }

  @Override
  public LmsNotification save(LmsNotification notification) {
    return lmsNotificationRepository.save(notification);
  }

  @Override
  public LmsNotification findById(Integer id) {
    return lmsNotificationRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsNotificationRepository.deleteById(id);
  }
}
