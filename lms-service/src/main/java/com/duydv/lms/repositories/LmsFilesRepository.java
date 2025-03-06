package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsFiles;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsFilesRepository extends JpaRepository<LmsFiles, Integer> {

  @Query(value = "SELECT * FROM educa_Lms.`Lms_files` o WHERE o.`is_active` = 1 AND o.`deleted_at` IS NULL", nativeQuery = true)
  List<LmsFiles> findAll();

  List<LmsFiles> findByIdIn(List<Integer> ids);
}
