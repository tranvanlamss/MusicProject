package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.GenreEntity;
import com.example.soundlifeapi.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Integer> {
    @Query("select p from PlaylistEntity  p where p.name like %:name%")
    PlaylistEntity findPlaylistByName(String name);

    @Query("select p from PlaylistEntity  p where p.name like %:name% and p.deleted =false ")
    List<PlaylistEntity> findByNameClient(String name);

    @Query("select p from PlaylistEntity  p where p.name like %:name% ")
    List<PlaylistEntity> findListByName(String name);
    @Query("select p from PlaylistEntity  p where p.deleted=false ")
    List<PlaylistEntity> listAllPlaylistClient();
}
