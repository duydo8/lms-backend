package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsFiles;
import com.duydv.lms.repositories.LmsFilesRepository;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsFilesServiceImpl implements LmsFilesService {

  private final LmsFilesRepository lmsFilesRepository;

  @Override
  public List<LmsFiles> findAll() {
    return lmsFilesRepository.findAll();
  }

  @Override
  public List<LmsFiles> findByIds(List<Integer> ids) {
    if (CollectionUtils.isEmpty(ids)) {
      return Collections.emptyList();
    }
    return lmsFilesRepository.findByIdIn(ids);
  }


}
