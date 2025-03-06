package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsSubject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsSubjectRepository extends JpaRepository<LmsSubject, Integer> {

  @Query("select s from LmsSubject s where s.isActive= true and s.name = ?1")
  LmsSubject findByName(String name);

  @Query("select s from LmsSubject s where s.isActive= true and s.id = ?1")
  LmsSubject findIsActiveById(Integer id);

  @Query("select s from LmsSubject s where s.isActive= true")
  List<LmsSubject> findAllIsActive();

  @Query("select s from LmsSubject s where s.isActive = true and s.name like :name")
  List<LmsSubject> findLikeName(@Param("name") String name);
}
