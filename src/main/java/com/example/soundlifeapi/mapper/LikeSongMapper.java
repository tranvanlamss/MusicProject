package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.LikeSongDto;
import com.example.soundlifeapi.entity.LikeSongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface LikeSongMapper {
    List<LikeSongDto> convertListToDto(List<LikeSongEntity> entityList);
    List<LikeSongEntity> convertListToEntity(List<LikeSongDto> dtoList);
    LikeSongDto convertToDto(LikeSongEntity likeSongEntity);
    LikeSongEntity convertToEntity(LikeSongDto likeSongDto);
}
