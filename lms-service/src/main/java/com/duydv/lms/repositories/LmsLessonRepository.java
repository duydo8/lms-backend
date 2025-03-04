package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsLessons;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsLessonRepository extends JpaRepository<LmsLessons, Integer> {

  @Query(value = "SELECT * FROM educa_Lms.`Lms_lessons` o WHERE o.`is_active` = 1 AND o.`deleted_at` IS NULL", nativeQuery = true)
  List<LmsLessons> findAll();

  @Query(value = "SELECT * FROM educa_Lms.`Lms_lessons` o WHERE o.`stage_id` IN ?1 AND o.`is_active` = 1 AND o.`deleted_at` IS NULL", nativeQuery = true)
  List<LmsLessons> findByStageIdIn(Set<Integer> stageIds);

  List<LmsLessons> findByIdIn(Collection<Integer> ids);
}
