package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.TopDto;
import com.example.soundlifeapi.entity.TopEntity;
import com.example.soundlifeapi.mapper.TopMapper;
import com.example.soundlifeapi.repository.TopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TopServiceImpl implements TopService{

    @Autowired
    TopRepository topRepository;

    @Autowired
    TopMapper topMapper;

    @Override
    public List<TopDto> getAllTop(Pageable pageable) {
        List<TopEntity> topEntities = topRepository.findAll(pageable).getContent();
        List<TopDto> topDto = topMapper.convertListToDto(topEntities);
        return topDto;
    }

    @Override
    public List<TopDto> getAll() {
        List<TopEntity> topEntities = topRepository.findAll();
        List<TopDto> topDto = topMapper.convertListToDto(topEntities);
        return topDto;
    }

    @Override
    public TopDto create(TopDto topDto) {
        TopEntity topEntityConvert = topMapper.convertToEntity(topDto);
        TopEntity topEntity = topRepository.save(topEntityConvert);
        TopDto dto = topMapper.convertToDto(topEntity);
        return dto;
    }

    @Override
    public TopDto getById(int id) {
        TopEntity topEntity = topRepository.findById(id).get();
        TopDto topDto = topMapper.convertToDto(topEntity);
        return topDto;
    }

    @Override
    public void deleteById(int id) {
        topRepository.deleteById(id);
    }

    @Override
    public TopDto findByName(String name) {
        TopEntity entity = topRepository.findByName(name);
        TopDto dto = topMapper.convertToDto(entity);
        return dto;
    }

    @Override
    public List<TopDto> listAllTopClient() {
        List<TopEntity> topEntities = topRepository.listAllTopClient();
        List<TopDto> topDto = topMapper.convertListToDto(topEntities);
        return topDto;
    }

    @Override
    public List<TopDto> findByNameClient(String name) {
        List<TopEntity> topEntities = topRepository.findByNameClient(name);
        List<TopDto> topDto = topMapper.convertListToDto(topEntities);
        return topDto;
    }

    @Override
    public long countTop() {
        return topRepository.count();
    }


}
