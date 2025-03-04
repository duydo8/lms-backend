package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsFiles;
import java.util.List;

public interface LmsFilesService {

  List<LmsFiles> findAll();

  List<LmsFiles> findByIds(List<Integer> ids);



}
