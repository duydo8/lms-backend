package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsDistricts;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsDistrictsRepository extends JpaRepository<LmsDistricts, Integer> {

  LmsDistricts findBySlug(String slug);

  List<LmsDistricts> findByProvinceCode(String provinceCode);
}
