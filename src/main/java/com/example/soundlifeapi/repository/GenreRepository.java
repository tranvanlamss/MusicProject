package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.AlbumEntity;
import com.example.soundlifeapi.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {
    @Query("select p from GenreEntity  p where p.name like %:name%")
    GenreEntity findGenreByName(String name);
    @Query("select p from GenreEntity  p where p.name like %:name%")
    List<GenreEntity> findListGenreByName(@PathVariable("name") String name);

    @Query("select p from GenreEntity  p where p.name like %:name% and p.deleted = false ")
    List<GenreEntity> findByNameClient(@PathVariable("name") String name);
    @Query("select p from GenreEntity  p where p.deleted=false ")
    List<GenreEntity> listAllGenreClient();
}
