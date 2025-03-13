package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsAccountRepository extends JpaRepository<LmsAccount, Integer> {

  @Query("select a from LmsAccount a where a.status = 1")
  Page<LmsAccount> findAllIsActive(Pageable pageable);

  @Query("SELECT a FROM LmsAccount a WHERE a.status = 1 and a.fullName LIKE CONCAT('%', :fullName, '%')")
  Page<LmsAccount> findAllIsActiveByFullName(@Param("fullName") String fullName, Pageable pageable);

  Page<LmsAccount> findAllByFullName(String fullName, Pageable pageable);

  @Query("select a from LmsAccount a where a.status = 1 and a.phone = ?1")
  LmsAccount findByPhone(String phone);

  @Query("select a from LmsAccount a where a.status = 1 and a.phone = ?1 and a.password = ?2")
  LmsAccount findByPhoneAndPassword(String phone, String password);

  @Query("select a from LmsAccount a where a.status = 1 and a.id = ?1")
  LmsAccount findByIdAndIsActive(int id);
}
