package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsAccountRepository extends JpaRepository<LmsAccount, Integer> {

}
