package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.SongDto;
import com.example.soundlifeapi.dto.TopDto;
import com.example.soundlifeapi.entity.SongEntity;
import com.example.soundlifeapi.entity.TopEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TopMapper {
    List<TopDto> convertListToDto(List<TopEntity> entityList);
    List<TopEntity> convertListToEntity(List<TopDto> dtoList);
    TopDto convertToDto(TopEntity topEntity);
    TopEntity convertToEntity(TopDto topDto);
}
