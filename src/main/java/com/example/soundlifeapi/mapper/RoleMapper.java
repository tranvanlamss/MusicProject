package com.example.soundlifeapi.mapper;

import com.example.soundlifeapi.dto.RoleDto;
import com.example.soundlifeapi.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RoleMapper {
    List<RoleDto> convertListToDto(List<RoleEntity> entityList);
    List<RoleEntity> convertListToEntity(List<RoleDto> dtoList);
    RoleDto convertToDto(RoleEntity roleEntity);
    RoleEntity convertToEntity(RoleDto roleDto);
}
