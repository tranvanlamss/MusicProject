package com.example.soundlifeapi.repository;


import com.example.soundlifeapi.entity.GenreEntity;
import com.example.soundlifeapi.entity.PlaylistSongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PlaylistSongRepository extends JpaRepository<PlaylistSongEntity, Integer> {
    @Modifying
    @Query("delete from PlaylistSongEntity p where p.song_id =:song_id")
    void deleteBySongId(@PathVariable("song_id") int song_id);

    @Query("select p from PlaylistSongEntity  p where p.deleted= false ")
    List<PlaylistSongEntity> listAllPlaylistSongClient();
}
