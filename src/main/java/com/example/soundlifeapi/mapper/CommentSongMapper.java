package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.CommentSongDto;
import com.example.soundlifeapi.entity.CommentSongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CommentSongMapper {
    List<CommentSongDto> convertListToDto(List<CommentSongEntity> entityList);
    List<CommentSongEntity> convertListToEntity(List<CommentSongDto> dtoList);
    CommentSongDto convertToDto(CommentSongEntity commentSongEntity);
    CommentSongEntity convertToEntity(CommentSongDto commentSongDto);
}
