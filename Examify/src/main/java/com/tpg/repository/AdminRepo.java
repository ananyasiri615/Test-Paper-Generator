package com.tpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpg.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

}