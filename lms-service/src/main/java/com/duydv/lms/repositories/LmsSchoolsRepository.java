package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsSchools;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsSchoolsRepository extends JpaRepository<LmsSchools, Integer> {

  List<LmsSchools> findByDistrictId(Integer distId);
}
