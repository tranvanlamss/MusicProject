package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.LikeMvDto;
import com.example.soundlifeapi.entity.LikeMvEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface LikeMvMapper {
    List<LikeMvDto> convertListToDto(List<LikeMvEntity> entityList);
    List<LikeMvEntity> convertListToEntity(List<LikeMvDto> dtoList);
    LikeMvDto convertToDto(LikeMvEntity likeMvEntity);
    LikeMvEntity convertToEntity(LikeMvDto likeMvDto);
}
