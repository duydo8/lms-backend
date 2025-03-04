package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsDistricts;
import java.util.List;

public interface LmsDistrictsService {

  List<LmsDistricts> findByProvinceCode(String provinceCode);

  LmsDistricts findBySlug(String slug);

  LmsDistricts findById(int i);
}
