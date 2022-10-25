package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.PlaylistDto;
import com.example.soundlifeapi.dto.PlaylistSongDto;
import com.example.soundlifeapi.entity.PlaylistEntity;
import com.example.soundlifeapi.entity.PlaylistSongEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlaylistSongService {

    PlaylistSongDto createPlaylistSong(PlaylistSongDto playlistSongDto);

    void deleteBySongId(int id);

    List<PlaylistSongDto> getAllPlaylistSong(Pageable pageable);
    List<PlaylistSongDto> listAllPlaylistSongClient();
    List<PlaylistDto> findByNameClient(String name);

}
