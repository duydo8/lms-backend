package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsFiles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LmsFilesService {

  Page<LmsFiles> findAllPageable(Pageable pageable);

  LmsFiles save(LmsFiles files);

  LmsFiles findById(Integer id);

  void deleteById(Integer id);

}
