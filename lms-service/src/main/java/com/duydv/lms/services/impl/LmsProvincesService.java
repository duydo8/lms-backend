package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsProvinces;

public interface LmsProvincesService {

  LmsProvinces findBySlug(String slug);

  LmsProvinces findByCode(String code);

  LmsProvinces findById(int i);
}
