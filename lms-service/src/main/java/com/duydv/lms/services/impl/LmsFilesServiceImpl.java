package com.duydv.lms.services.impl;

import com.duydv.lms.entities.LmsFiles;
import com.duydv.lms.repositories.LmsFilesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LmsFilesServiceImpl implements LmsFilesService {

  private LmsFilesRepository lmsFilesRepository;

  @Override
  public Page<LmsFiles> findAllPageable(Pageable pageable) {
    return lmsFilesRepository.findAll(pageable);
  }

  @Override
  public LmsFiles save(LmsFiles files) {
    return lmsFilesRepository.save(files);
  }

  @Override
  public LmsFiles findById(Integer id) {
    return lmsFilesRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Integer id) {
    lmsFilesRepository.deleteById(id);
  }
}
