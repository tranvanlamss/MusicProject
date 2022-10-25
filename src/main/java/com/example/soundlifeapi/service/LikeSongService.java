package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.LikeSongDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.LikeSongEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeSongService {
    List<LikeSongDto> getAll();
    List<LikeSongDto> getAllLikeSong(Pageable pageable);
    LikeSongDto createLikeSong(LikeSongDto likeSongDto);
    LikeSongDto getById(int id);
    void deleteById(int id);
    int getCount(@Param("song_id") int song_id);
    List<LikeSongDto> listAllLikeSongClient();
}
