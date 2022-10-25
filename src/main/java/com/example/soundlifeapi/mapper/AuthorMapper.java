package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.AlbumDto;
import com.example.soundlifeapi.dto.AuthorDto;
import com.example.soundlifeapi.entity.AlbumEntity;
import com.example.soundlifeapi.entity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AuthorMapper {
    List<AuthorDto> convertListToDto(List<AuthorEntity> entityList);
    List<AuthorEntity> convertListToEntity(List<AuthorDto> dtoList);
    AuthorDto convertToDto(AuthorEntity authorEntity);
    AuthorEntity convertToEntity(AuthorDto authorDto);
}
