package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.TopDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TopService {
    List<TopDto> getAllTop(Pageable pageable);
    List<TopDto> getAll();
    TopDto create(TopDto topDto);
    TopDto getById(int id);
    void deleteById(int id);
    TopDto findByName(String name);
    List<TopDto> listAllTopClient();
    List<TopDto> findByNameClient(String name);
    long countTop();
}
