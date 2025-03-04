package com.duydv.lms.entities;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LmsProfileScheduleId implements Serializable {

  private Integer profileId;
  private Integer scheduleId;
}
