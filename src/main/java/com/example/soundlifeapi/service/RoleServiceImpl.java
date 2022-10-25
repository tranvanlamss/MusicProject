package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.RoleDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.RoleEntity;
import com.example.soundlifeapi.mapper.RoleMapper;
import com.example.soundlifeapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<RoleDto> getAllRole(Pageable pageable) {
        List<RoleEntity> roleEntityList = roleRepository.findAll(pageable).getContent();
        List<RoleDto> roleDtoList = roleMapper.convertListToDto(roleEntityList);
        return roleDtoList;
    }

    @Override
    public List<RoleDto> getAll() {
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        List<RoleDto> roleDtoList = roleMapper.convertListToDto(roleEntityList);
        return roleDtoList;
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        RoleEntity roleEntityConvert = roleMapper.convertToEntity(roleDto);
        RoleEntity roleEntity = roleRepository.save(roleEntityConvert);
        RoleDto dto = roleMapper.convertToDto(roleEntity);
        return dto;
    }

    @Override
    public RoleDto getById(int id) {
        RoleEntity roleEntity = roleRepository.findById(id).get();
        RoleDto roleDto = roleMapper.convertToDto(roleEntity);
        return roleDto;
    }

    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public RoleDto findRoleByName(String name) {
        RoleEntity entity = roleRepository.findRoleByName(name);
        RoleDto dto = roleMapper.convertToDto(entity);
        return dto;
    }
}
