package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsSchools;
import java.util.List;

public interface LmsSchoolsService {

  List<LmsSchools> findByDistrictCode(Integer code);

  List<LmsSchools> findByDistrictId(Integer distId);

  LmsSchools findById(int i);
}
