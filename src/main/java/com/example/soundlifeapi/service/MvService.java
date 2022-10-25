package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.MvDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.MvEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MvService {
    List<MvDto> getAll();
    List<MvDto> getAllMv(Pageable pageable);
    MvDto createMv(MvDto mvDto);
    MvDto getById(int id);
    void deleteById(int id);
    MvDto findMvByName(String name);
    List<MvDto> listAllMvClient();
}
