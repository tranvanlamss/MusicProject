package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.AlbumDto;
import com.example.soundlifeapi.entity.AlbumEntity;
import com.example.soundlifeapi.mapper.AlbumMapper;
import com.example.soundlifeapi.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AlbumMapper albumMapper;

    @Override
    public List<AlbumDto> getAll() {
        List<AlbumEntity> albumEntityList = albumRepository.findAll();
        List<AlbumDto> albumDtoList = albumMapper.convertListToDto(albumEntityList);
        return albumDtoList;
    }

    @Override
    public List<AlbumDto> getAllAlbum(Pageable pageable) {
        List<AlbumEntity> albumEntityList = albumRepository.findAll(pageable).getContent();
        List<AlbumDto> albumDtoList = albumMapper.convertListToDto(albumEntityList);
        return albumDtoList;
    }


    @Override
    public AlbumDto createAlbum(AlbumDto albumDto) {
        if(albumDto.getName() == null){
            throw new RuntimeException("name already");
        }
        AlbumEntity albumEntityConvert = albumMapper.convertToEntity(albumDto);
        AlbumEntity albumEntity = albumRepository.save(albumEntityConvert);
        AlbumDto dto = albumMapper.convertToDto(albumEntity);
        return dto;
    }

    @Override
    public AlbumDto getById(int id) {
        AlbumEntity albumEntity = albumRepository.findById(id).get();
        AlbumDto albumDto = albumMapper.convertToDto(albumEntity);
        return albumDto;
    }

    @Override
    public void deleteById(int id) {
        albumRepository.deleteById(id);
    }

    @Override
    public AlbumDto findAlbumByName(String name) {
        AlbumEntity entity = albumRepository.findAlbumByName(name);
        AlbumDto dto = albumMapper.convertToDto(entity);
        return dto;
    }

    @Override
    public List<AlbumDto> findListAlbumByName(String name) {
        List<AlbumEntity> albumEntityList = albumRepository.findListAlbumByName(name);
        List<AlbumDto> albumDtoList = albumMapper.convertListToDto(albumEntityList);
        return albumDtoList;
    }

    @Override
    public List<AlbumDto> listAllAlbumClient() {
        List<AlbumEntity> albumEntityList = albumRepository.listAllAlbumClient();
        List<AlbumDto> albumDtoList = albumMapper.convertListToDto(albumEntityList);
        return albumDtoList;
    }

    @Override
    public List<AlbumDto> findAlbumByNameClient(String name) {
        List<AlbumEntity> albumEntityList = albumRepository.findAlbumByNameClient(name);
        List<AlbumDto> albumDtoList = albumMapper.convertListToDto(albumEntityList);
        return albumDtoList;
    }

    @Override
    public long countAlbum() {
        return albumRepository.count();
    }

}
