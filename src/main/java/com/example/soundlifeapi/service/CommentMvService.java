package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.CommentMvDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.CommentMvEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentMvService {
    List<CommentMvDto> getAll();
    List<CommentMvDto> getAllCommentMv(Pageable pageable);
    CommentMvDto createCommentMv(CommentMvDto commentMvDto);
    CommentMvDto getById(int id);
    void deleteById(int id);
    List<CommentMvDto> listAllCommentMvClient();
    int countComment(@Param("mv_id") int mv_id);
}
