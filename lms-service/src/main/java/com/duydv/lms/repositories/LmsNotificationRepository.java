package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsNotificationRepository extends JpaRepository<LmsNotification, Integer> {

}
