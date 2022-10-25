package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.AlbumEntity;
import com.example.soundlifeapi.entity.CommentMvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommentMvRepository extends JpaRepository<CommentMvEntity, Integer> {

    @Query("SELECT COUNT(u) FROM CommentMvEntity u WHERE u.mv_id=:mv_id")
    int countComment(@Param("mv_id") int mv_id);
    @Query("select p from CommentMvEntity  p where p.deleted=false ")
    List<CommentMvEntity> listAllCommentMvClient();
}
