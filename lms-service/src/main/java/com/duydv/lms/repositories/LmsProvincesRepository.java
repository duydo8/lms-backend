package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsProvinces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsProvincesRepository extends JpaRepository<LmsProvinces, Integer> {

  LmsProvinces findByCode(String code);

  LmsProvinces findBySlug(String slug);
}
