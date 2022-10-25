package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.RoleDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.SingerEntity;
import com.example.soundlifeapi.entity.SongEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SingerService {
    List<SingerDto> getAllSinger(Pageable pageable);
    List<SingerDto> getAll();
    SingerDto create(SingerDto singerDto);
    SingerDto getById(int id);
    void deleteById(int id);
    SingerDto findByName(String name);
    List<SingerDto> listAllSingerClient();
    List<SingerDto> findByNameClient(String name);

    long countSinger();
}
