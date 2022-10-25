package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.MvDto;
import com.example.soundlifeapi.dto.UserDto;
import com.example.soundlifeapi.entity.MvEntity;
import com.example.soundlifeapi.mapper.MvMapper;
import com.example.soundlifeapi.repository.MvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MvServiceImpl implements MvService{
    @Autowired
    MvRepository mvRepository;

    @Autowired
    UserService userService;
    @Autowired
    MvMapper mvMapper;

    @Override
    public List<MvDto> getAll() {
        List<MvEntity> mvEntityList = mvRepository.findAll();
        List<MvDto> mvDtoList = mvMapper.convertListToDto(mvEntityList);
        return mvDtoList;
    }

    @Override
    public List<MvDto> getAllMv(Pageable pageable) {
        List<MvEntity> mvEntityList = mvRepository.findAll(pageable).getContent();
        List<MvDto> mvDtoList = mvMapper.convertListToDto(mvEntityList);
        return mvDtoList;
    }

    @Override
    public MvDto createMv(MvDto mvDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDto userDto = userService.findUserByName(username);
        mvDto.setUser_id(userDto.getId());
        MvEntity mvEntityConvert = mvMapper.convertToEntity(mvDto);
        MvEntity mvEntity = mvRepository.save(mvEntityConvert);
        MvDto dto = mvMapper.convertToDto(mvEntity);
        return dto;
    }

    @Override
    public MvDto getById(int id) {
        MvEntity mvEntity = mvRepository.findById(id).get();
        MvDto mvDto = mvMapper.convertToDto(mvEntity);
        return mvDto;
    }

    @Override
    public void deleteById(int id) {
        mvRepository.deleteById(id);
    }

    @Override
    public MvDto findMvByName(String name) {
        MvEntity entity = mvRepository.findMvByName(name);
        MvDto dto = mvMapper.convertToDto(entity);
        return dto;
    }

    @Override
    public List<MvDto> listAllMvClient() {
        List<MvEntity> mvEntityList = mvRepository.listAllMvClient();
        List<MvDto> mvDtoList = mvMapper.convertListToDto(mvEntityList);
        return mvDtoList;
    }
}
