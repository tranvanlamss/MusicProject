package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.AlbumEntity;
import com.example.soundlifeapi.entity.SingerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {
    @Query("select p from AlbumEntity  p where p.name like %:name%")
    AlbumEntity findAlbumByName(String name);

    @Query("select p from AlbumEntity  p where p.name like %:name% and p.deleted = false ")
    List<AlbumEntity> findAlbumByNameClient(String name);

    @Query("select p from AlbumEntity  p where p.name like %:name%")
    List<AlbumEntity> findListAlbumByName(@PathVariable("name") String name);

    @Query("select p from AlbumEntity  p where p.deleted=false ")
    List<AlbumEntity> listAllAlbumClient();


}
