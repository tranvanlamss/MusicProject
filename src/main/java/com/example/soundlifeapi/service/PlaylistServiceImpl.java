package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.PlaylistDto;
import com.example.soundlifeapi.dto.UserDto;
import com.example.soundlifeapi.entity.PlaylistEntity;
import com.example.soundlifeapi.mapper.PlaylistMapper;
import com.example.soundlifeapi.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaylistServiceImpl implements PlaylistService{
    @Autowired
    PlaylistRepository playlistRepository;
    @Autowired
    PlaylistMapper playlistMapper;
    @Autowired
    UserService userService;



    private List<PlaylistDto> listToDto;


    @Override
    public List<PlaylistDto> getAll() {
        List<PlaylistEntity> playlistEntityList = playlistRepository.findAll();
        listToDto = playlistMapper.convertListToDto(playlistEntityList);
        return listToDto;
    }

    @Override
    public List<PlaylistDto> getAllPlaylist(Pageable pageable) {
        List<PlaylistEntity> playlistEntityList = playlistRepository.findAll(pageable).getContent();
        List<PlaylistDto> listToDto = playlistMapper.convertListToDto(playlistEntityList);
        return listToDto;
    }

    @Override
    public PlaylistDto createPlaylist(PlaylistDto playlistDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDto userDto = userService.findUserByName(username);
        playlistDto.setUser_id(userDto.getId());
        PlaylistEntity playlistEntityConvert = playlistMapper.convertToEntity(playlistDto);
        PlaylistEntity playlistEntity = playlistRepository.save(playlistEntityConvert);
        PlaylistDto dto = playlistMapper.convertToDto(playlistEntity);
        return dto;
    }

    @Override
    public PlaylistDto getById(int id) {
        PlaylistEntity playlistEntity = playlistRepository.findById(id).get();
        PlaylistDto playlistDto = playlistMapper.convertToDto(playlistEntity);
        return playlistDto;
    }

    @Override
    public void deleteById(int id) {
        playlistRepository.deleteById(id);
    }

    @Override
    public PlaylistDto findPlaylistByName(String name) {
        PlaylistEntity playlistEntity = playlistRepository.findPlaylistByName(name);
        PlaylistDto playlistDto = playlistMapper.convertToDto(playlistEntity);
        return playlistDto;
    }

    @Override
    public List<PlaylistDto> listAllPlaylistClient() {
        List<PlaylistEntity> playlistEntityList = playlistRepository.listAllPlaylistClient();
        listToDto = playlistMapper.convertListToDto(playlistEntityList);
        return listToDto;
    }

    @Override
    public List<PlaylistDto> findByNameClient(String name) {
        List<PlaylistEntity> playlistEntityList = playlistRepository.findByNameClient(name);
        listToDto = playlistMapper.convertListToDto(playlistEntityList);
        return listToDto;
    }


}
