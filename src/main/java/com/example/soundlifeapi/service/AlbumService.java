package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.AlbumDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.AlbumEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AlbumService {
    List<AlbumDto> getAll();
    List<AlbumDto> getAllAlbum(Pageable pageable);
    AlbumDto createAlbum(AlbumDto albumDto);
    AlbumDto getById(int id);
    void deleteById(int id);
    AlbumDto findAlbumByName(String name);
    List<AlbumDto> findListAlbumByName(String name);
    List<AlbumDto> listAllAlbumClient();
    List<AlbumDto> findAlbumByNameClient(String name);
    long countAlbum();
}
