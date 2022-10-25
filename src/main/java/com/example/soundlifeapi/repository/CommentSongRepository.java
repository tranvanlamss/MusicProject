package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.AlbumEntity;
import com.example.soundlifeapi.entity.CommentSongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommentSongRepository extends JpaRepository<CommentSongEntity,Integer> {

    @Query("select p from CommentSongEntity  p where p.deleted=false ")
    List<CommentSongEntity> listAllCommentSongClient();

    @Query("select p from CommentSongEntity  p where p.song_id=:song_id ")
    List<CommentSongEntity> findCommentSongBySongId(@PathVariable("song_id") int song_id);

    @Query("SELECT COUNT(u) FROM CommentSongEntity u WHERE u.song_id=:song_id")
    int countComment(@Param("song_id") int song_id);

}
