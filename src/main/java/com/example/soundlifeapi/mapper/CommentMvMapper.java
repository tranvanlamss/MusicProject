package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.CommentMvDto;
import com.example.soundlifeapi.entity.CommentMvEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CommentMvMapper {
    List<CommentMvDto> convertListToDto(List<CommentMvEntity> entityList);
    List<CommentMvEntity> convertListToEntity(List<CommentMvDto> dtoList);
    CommentMvDto convertToDto(CommentMvEntity commentMvEntity);
    CommentMvEntity convertToEntity(CommentMvDto commentMvDto);
}
