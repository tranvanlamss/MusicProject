package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.AlbumDto;
import com.example.soundlifeapi.entity.AlbumEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AlbumMapper {
    List<AlbumDto> convertListToDto(List<AlbumEntity> entityList);
    List<AlbumEntity> convertListToEntity(List<AlbumDto> dtoList);
    AlbumDto convertToDto(AlbumEntity albumEntity);
    AlbumEntity convertToEntity(AlbumDto albumDto);
}
