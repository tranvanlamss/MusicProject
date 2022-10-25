package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.GenreDto;
import com.example.soundlifeapi.entity.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GenreMapper {
    List<GenreDto> convertListToDto(List<GenreEntity> entityList);
    List<GenreEntity> convertListToEntity(List<GenreDto> dtoList);
    GenreDto convertToDto(GenreEntity genreEntity);
    GenreEntity convertToEntity(GenreDto genreDto);
}
