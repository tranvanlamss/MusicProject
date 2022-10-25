package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.GenreEntity;
import com.example.soundlifeapi.entity.MvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MvRepository extends JpaRepository<MvEntity, Integer> {
    @Query("select p from MvEntity  p where p.name like %:name%")
    MvEntity findMvByName(String name);

    @Query("select p from MvEntity  p where p.deleted=false ")
    List<MvEntity> listAllMvClient();
}
