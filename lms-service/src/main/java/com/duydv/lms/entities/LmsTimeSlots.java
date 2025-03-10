package com.duydv.lms.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Entity
@Data
@Table(name = "lms_time_slots")
public class LmsTimeSlots implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  private Integer id;

  private String name;

  @Column(name = "day_of_week")
  private Integer dayOfWeek;

  @Column(name = "start_time")
  private String startTime;

  @Column(name = "end_time")
  private String endTime;

  @Column(name = "created_at")
  private Date createdAt = new Date();

  @Column(name = "updated_at")
  private Date updatedAt;
}
