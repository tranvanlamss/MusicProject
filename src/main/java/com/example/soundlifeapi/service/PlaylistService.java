package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.PlaylistDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.PlaylistEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlaylistService {
    List<PlaylistDto> getAll();
    List<PlaylistDto> getAllPlaylist(Pageable pageable);
    PlaylistDto createPlaylist(PlaylistDto playlistDto);
    PlaylistDto getById(int id);
    void deleteById(int id);
    PlaylistDto findPlaylistByName(String name);
    List<PlaylistDto> listAllPlaylistClient();
    List<PlaylistDto> findByNameClient(String name);

}
