package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.SongDto;
import com.example.soundlifeapi.entity.SongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SongMapper {
    List<SongDto> convertListToDto(List<SongEntity> entityList);
    List<SongEntity> convertListToEntity(List<SongDto> dtoList);
    SongDto convertToDto(SongEntity songEntity);
    SongEntity convertToEntity(SongDto songDto);
}
