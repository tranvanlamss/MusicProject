package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.PlaylistDto;
import com.example.soundlifeapi.entity.PlaylistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PlaylistMapper {
    List<PlaylistDto> convertListToDto(List<PlaylistEntity> entityList);
    List<PlaylistEntity> convertListToEntity(List<PlaylistDto> dtoList);
    PlaylistDto convertToDto(PlaylistEntity playlistEntity);
    PlaylistEntity convertToEntity(PlaylistDto playlistDto);
}
