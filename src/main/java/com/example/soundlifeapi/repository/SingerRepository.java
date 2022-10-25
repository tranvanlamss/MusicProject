package com.example.soundlifeapi.repository;


import com.example.soundlifeapi.entity.SingerEntity;
import com.example.soundlifeapi.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SingerRepository extends JpaRepository<SingerEntity, Integer> {
    @Query("select p from SingerEntity  p where p.name like %:name%")
    SingerEntity findByName(String name);

    @Query("select p from SingerEntity  p where p.name like %:name% and p.deleted = false ")
    List<SingerEntity> findByNameClient(@PathVariable("name") String name);

    @Query("select p from SingerEntity  p where p.deleted=false ")
    List<SingerEntity> listAllSingerClient();




}
