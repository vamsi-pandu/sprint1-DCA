package com.cg.dca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dca.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
