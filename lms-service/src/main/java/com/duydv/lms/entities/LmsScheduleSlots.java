package com.duydv.lms.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lms_schedule_slots")
@IdClass(LmsScheduleSlotsPK.class)
public class LmsScheduleSlots implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "schedule_id")
  private Integer scheduleId;

  @Id
  @NotNull
  @Column(name = "time_slot_id")
  private Integer timeSlotId;

}
