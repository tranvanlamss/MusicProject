package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.LikeMvDto;
import com.example.soundlifeapi.dto.UserDto;
import com.example.soundlifeapi.entity.LikeMvEntity;
import com.example.soundlifeapi.mapper.LikeMvMapper;
import com.example.soundlifeapi.repository.LikeMvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeMvServiceImpl implements LikeMvService{
    @Autowired
    LikeMvRepository likeMvRepository;
    @Autowired
    LikeMvMapper likeMvMapper;

    @Autowired
    UserService userService;

    @Override
    public List<LikeMvDto> getAll() {
        List<LikeMvEntity> entityList = likeMvRepository.findAll();
        List<LikeMvDto> dtoList = likeMvMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public List<LikeMvDto> getAllLikeMv(Pageable pageable) {
        List<LikeMvEntity> entityList = likeMvRepository.findAll(pageable).getContent();
        List<LikeMvDto> dtoList = likeMvMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public LikeMvDto createLikeMv(LikeMvDto likeMvDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDto userDto = userService.findUserByName(username);
        likeMvDto.setUser_id(userDto.getId());
        likeMvDto.setLike_mv(1);
        LikeMvEntity likeMvEntityConvert = likeMvMapper.convertToEntity(likeMvDto);
        LikeMvEntity likeMvEntity = likeMvRepository.save(likeMvEntityConvert);
        LikeMvDto dto = likeMvMapper.convertToDto(likeMvEntity);
        return dto;
    }

    @Override
    public LikeMvDto getById(int id) {

        LikeMvEntity likeMvEntity = likeMvRepository.findById(id).get();
        LikeMvDto likeMvDto = likeMvMapper.convertToDto(likeMvEntity);
        return likeMvDto;
    }

    @Override
    public void deleteById(int id) {
        likeMvRepository.deleteById(id);
    }

    @Override
    public List<LikeMvDto> listAllLikeMvClient() {
        List<LikeMvEntity> entityList = likeMvRepository.listAllLikeMvClient();
        List<LikeMvDto> dtoList = likeMvMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public int countLike(int mv_id) {
        return likeMvRepository.countLike(mv_id);
    }


}
