package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.UserDto;
import com.example.soundlifeapi.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    List<UserDto> convertListToDto(List<UserEntity> entityList);
    List<UserEntity> convertListToEntity(List<UserDto> dtoList);
    UserDto convertToDto(UserEntity userEntity);
    UserEntity convertToEntity(UserDto userDto);
}
