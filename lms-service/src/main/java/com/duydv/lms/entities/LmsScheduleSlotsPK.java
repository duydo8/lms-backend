package com.duydv.lms.entities;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LmsScheduleSlotsPK implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer scheduleId;

  private Integer timeSlotId;
}
