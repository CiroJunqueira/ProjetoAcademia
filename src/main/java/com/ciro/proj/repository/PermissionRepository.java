package com.ciro.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciro.proj.domain.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

	Permission findByDescription(String permission);
	
}
