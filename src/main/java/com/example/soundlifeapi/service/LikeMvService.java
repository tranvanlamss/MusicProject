package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.LikeMvDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.LikeMvEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeMvService {
    List<LikeMvDto> getAll();
    List<LikeMvDto> getAllLikeMv(Pageable pageable);
    LikeMvDto createLikeMv(LikeMvDto likeMvDto);
    LikeMvDto getById(int id);
    void deleteById(int id);
    List<LikeMvDto> listAllLikeMvClient();

    int countLike(@Param("mv_id") int mv_id);
}
