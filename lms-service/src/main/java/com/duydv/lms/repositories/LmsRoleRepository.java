package com.duydv.lms.repositories;

import com.duydv.lms.entities.LmsRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsRoleRepository extends JpaRepository<LmsRoles, Integer> {

}
