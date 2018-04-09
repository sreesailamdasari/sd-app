package com.sd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
