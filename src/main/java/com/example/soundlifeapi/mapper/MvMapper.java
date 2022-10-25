package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.MvDto;
import com.example.soundlifeapi.entity.MvEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MvMapper {
    List<MvDto> convertListToDto(List<MvEntity> entityList);
    List<MvEntity> convertListToEntity(List<MvDto> dtoList);
    MvDto convertToDto(MvEntity mvEntity);
    MvEntity convertToEntity(MvDto mvDto);
}
