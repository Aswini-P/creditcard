package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin,Long> {

}
