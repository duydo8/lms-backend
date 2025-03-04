package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsProfile;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsProfileRepository extends JpaRepository<LmsProfile, Integer> {

  List<LmsProfile> findByAccountId(int accountId);

  @Query(value = "select kp.* from Lms_profile kp join Lms_account ka on ka.id = kp.account_id where ka.phone = ?1", nativeQuery = true)
  List<LmsProfile> findByPhone(String phone);

  Page<LmsProfile> findByIsVip(int isVip, Pageable page);

  @Query(value = "SELECT a.`phone` FROM educa_Lms.`Lms_account` a WHERE a.`id` = (SELECT p.`account_id` FROM educa_Lms.`Lms_profile` p WHERE p.`id` = ?1)", nativeQuery = true)
  String getPhone(int profileId);

  Page<LmsProfile> findByIsPaid(int isPaid, Pageable page);

  List<LmsProfile> findByIsPaidOrderByIdDesc(int isPaid);

  List<LmsProfile> findByIdIn(Collection<Integer> profileIds);

  Page<LmsProfile> findByGradeId(int gradeId, Pageable pageable);

  Page<LmsProfile> findByStatus(int status, Pageable pageable);

  Page<LmsProfile> findByStatusAndIsPaid(int status, int isPaid, Pageable pageable);

  List<LmsProfile> findByAccountIdIn(Set<Integer> accountIds);

  LmsProfile findByLmsId(int id);
}
