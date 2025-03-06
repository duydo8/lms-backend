package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsProfileSchedule;
import com.duydv.lms.entities.LmsProfileScheduleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsProfileScheduleRepository extends
    JpaRepository<LmsProfileSchedule, LmsProfileScheduleId> {
}
