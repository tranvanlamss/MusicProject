package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.PlaylistDto;
import com.example.soundlifeapi.dto.PlaylistSongDto;
import com.example.soundlifeapi.entity.PlaylistEntity;

import com.example.soundlifeapi.entity.PlaylistSongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PlaylistSongMapper {
    List<PlaylistSongDto> convertListToDto(List<PlaylistSongEntity> entityList);
    List<PlaylistSongEntity> convertListToEntity(List<PlaylistSongDto> dtoList);
    PlaylistSongDto convertToDto(PlaylistSongEntity playlistSongEntity);
    PlaylistSongEntity convertToEntity(PlaylistSongDto playlistSongDto);
}
