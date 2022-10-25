package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.GenreEntity;
import com.example.soundlifeapi.entity.LikeMvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface LikeMvRepository extends JpaRepository<LikeMvEntity, Integer> {
    @Query("SELECT COUNT(u) FROM LikeMvEntity u WHERE u.mv_id=:mv_id")
    int countLike(@Param("mv_id") int mv_id);

    @Query("select p from LikeMvEntity  p where p.deleted=false ")
    List<LikeMvEntity> listAllLikeMvClient();
}