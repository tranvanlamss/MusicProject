package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    @Query("select p from RoleEntity  p where p.name like %:name%")
    RoleEntity findRoleByName(String name);
}
