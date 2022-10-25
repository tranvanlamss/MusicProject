package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.RoleDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.RoleEntity;
import com.example.soundlifeapi.entity.SingerEntity;
import com.example.soundlifeapi.entity.SongEntity;
import com.example.soundlifeapi.mapper.RoleMapper;
import com.example.soundlifeapi.mapper.SingerMapper;
import com.example.soundlifeapi.repository.RoleRepository;
import com.example.soundlifeapi.repository.SingerRepository;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.websocket.Session;
import java.util.List;

@Service
public class SingerServiceImpl implements SingerService{
    @Autowired
    SingerRepository singerRepository;

    @Autowired
    SingerMapper singerMapper;

    @Override
    public List<SingerDto> getAllSinger(Pageable pageable) {


        List<SingerEntity> singerEntityList = singerRepository.findAll(pageable).getContent();
        List<SingerDto> singerDtoList = singerMapper.convertListToDto(singerEntityList);
        return singerDtoList;
    }

    @Override
    public List<SingerDto> getAll() {
        List<SingerEntity> singerEntityList = singerRepository.findAll();
        List<SingerDto> singerDtoList = singerMapper.convertListToDto(singerEntityList);
        return singerDtoList;
    }

    @Override
    public SingerDto create(SingerDto singerDto) {
        SingerEntity singerEntityConvert = singerMapper.convertToEntity(singerDto);
        SingerEntity singerEntity = singerRepository.save(singerEntityConvert);
        SingerDto dto = singerMapper.convertToDto(singerEntity);
        return dto;
    }

    @Override
    public SingerDto getById(int id) {
        SingerEntity singerEntity = singerRepository.findById(id).get();
        SingerDto singerDto = singerMapper.convertToDto(singerEntity);
        return singerDto;
    }

    @Override
    public void deleteById(int id) {
        singerRepository.deleteById(id);
    }

    @Override
    public SingerDto findByName(String name) {
        SingerEntity entity = singerRepository.findByName(name);
        SingerDto dto = singerMapper.convertToDto(entity);
        return dto;
    }

    @Override
    public List<SingerDto> listAllSingerClient() {
        List<SingerEntity> singerEntityList = singerRepository.listAllSingerClient();
        List<SingerDto> singerDtoList = singerMapper.convertListToDto(singerEntityList);
        return singerDtoList;
    }

    @Override
    public List<SingerDto> findByNameClient(String name) {
        List<SingerEntity> singerEntityList = singerRepository.findByNameClient(name);
        List<SingerDto> singerDtoList = singerMapper.convertListToDto(singerEntityList);
        return singerDtoList;
    }

    @Override
    public long countSinger() {
        return singerRepository.count();
    }


}
