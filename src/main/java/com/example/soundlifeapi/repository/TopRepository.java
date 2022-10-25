package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.SingerEntity;
import com.example.soundlifeapi.entity.TopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopRepository extends JpaRepository<TopEntity, Integer> {
    @Query("select p from TopEntity  p where p.name like %:name%")
    TopEntity findByName(String name);

    @Query("select p from TopEntity  p where p.name like %:name% and p.deleted = false")
    List<TopEntity> findByNameClient(String name);

    @Query("select p from TopEntity  p where p.deleted=false ")
    List<TopEntity> listAllTopClient();
}
