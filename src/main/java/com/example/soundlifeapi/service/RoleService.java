package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.RoleDto;
import com.example.soundlifeapi.dto.SingerDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAllRole(Pageable pageable);
    List<RoleDto> getAll();
    RoleDto createRole(RoleDto roleDto);
    RoleDto getById(int id);
    void deleteById(int id);
    RoleDto findRoleByName(String name);
}
