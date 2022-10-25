package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.GenreEntity;
import com.example.soundlifeapi.entity.LikeSongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface LikeSongRepository extends JpaRepository<LikeSongEntity, Integer> {
    @Query("SELECT COUNT(u) FROM LikeSongEntity u WHERE u.song_id=:song_id")
    int countLike(@Param("song_id") int song_id);

    @Query("select p from LikeSongEntity  p where p.deleted=false ")
    List<LikeSongEntity> listAllLikeSongClient();

}
