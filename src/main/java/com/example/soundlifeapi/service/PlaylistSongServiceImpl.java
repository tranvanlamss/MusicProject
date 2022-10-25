package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.PlaylistDto;
import com.example.soundlifeapi.dto.PlaylistSongDto;
import com.example.soundlifeapi.dto.RoleDto;

import com.example.soundlifeapi.entity.PlaylistEntity;
import com.example.soundlifeapi.entity.PlaylistSongEntity;
import com.example.soundlifeapi.entity.RoleEntity;
import com.example.soundlifeapi.mapper.PlaylistMapper;
import com.example.soundlifeapi.mapper.PlaylistSongMapper;

import com.example.soundlifeapi.repository.PlaylistSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistSongServiceImpl implements PlaylistSongService{
    @Autowired
    PlaylistSongRepository playlistSongRepository;

    @Autowired
    PlaylistSongMapper playlistSongMapper;
    @Override
    public PlaylistSongDto createPlaylistSong(PlaylistSongDto playlistSongDto) {
        PlaylistSongEntity entityConvert = playlistSongMapper.convertToEntity(playlistSongDto);
        PlaylistSongEntity playlistSongEntity = playlistSongRepository.save(entityConvert);
        PlaylistSongDto dto = playlistSongMapper.convertToDto(playlistSongEntity);
        return dto;
    }

    @Override
    public void deleteBySongId(int id) {
        playlistSongRepository.deleteById(id);
    }

    @Override
    public List<PlaylistSongDto> getAllPlaylistSong(Pageable pageable) {
        List<PlaylistSongEntity> playlistSongEntities = playlistSongRepository.findAll(pageable).getContent();
        List<PlaylistSongDto> listToDto= playlistSongMapper.convertListToDto(playlistSongEntities);
        return listToDto;
    }

    @Override
    public List<PlaylistSongDto> listAllPlaylistSongClient() {
        List<PlaylistSongEntity> playlistSongEntities = playlistSongRepository.listAllPlaylistSongClient();
        List<PlaylistSongDto> listToDto= playlistSongMapper.convertListToDto(playlistSongEntities);
        return listToDto;
    }

    @Override
    public List<PlaylistDto> findByNameClient(String name) {
        return null;
    }
}
