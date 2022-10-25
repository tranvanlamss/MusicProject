package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.AlbumDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.AlbumEntity;
import com.example.soundlifeapi.entity.SingerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SingerMapper {
    List<SingerDto> convertListToDto(List<SingerEntity> entityList);
    List<SingerEntity> convertListToEntity(List<SingerDto> dtoList);
    SingerDto convertToDto(SingerEntity singerEntity);
    SingerEntity convertToEntity(SingerDto singerDto);
}
