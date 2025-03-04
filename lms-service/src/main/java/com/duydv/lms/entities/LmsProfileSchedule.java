package com.duydv.lms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Data
@Table(name = "lms_profile_schedule")
@IdClass(LmsProfileScheduleId.class)
public class LmsProfileSchedule {

  @Id
  private Integer profileId;
  @Id
  private Integer scheduleId;
  @CreatedDate
  private Date createdAt;
}
