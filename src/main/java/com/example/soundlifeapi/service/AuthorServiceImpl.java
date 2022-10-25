package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.AuthorDto;
import com.example.soundlifeapi.entity.AuthorEntity;
import com.example.soundlifeapi.mapper.AuthorMapper;
import com.example.soundlifeapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorMapper authorMapper;

    @Override
    public List<AuthorDto> getAll() {
        List<AuthorEntity> albumEntityList = authorRepository.findAll();
        List<AuthorDto> albumDtoList = authorMapper.convertListToDto(albumEntityList);
        return albumDtoList;
    }

    @Override
    public List<AuthorDto> getAll(Pageable pageable) {
        List<AuthorEntity> albumEntityList = authorRepository.findAll(pageable).getContent();
        List<AuthorDto> albumDtoList = authorMapper.convertListToDto(albumEntityList);
        return albumDtoList;
    }

    @Override
    public AuthorDto create(AuthorDto authorDto) {
        AuthorEntity authorEntityConvert = authorMapper.convertToEntity(authorDto);
        AuthorEntity authorEntity = authorRepository.save(authorEntityConvert);
        AuthorDto dto = authorMapper.convertToDto(authorEntity);
        return dto;
    }

    @Override
    public AuthorDto getById(int id) {
        AuthorEntity authorEntity = authorRepository.findById(id).get();
        AuthorDto authorDto = authorMapper.convertToDto(authorEntity);
        return authorDto;
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto findByName(String name) {
        AuthorEntity entity = authorRepository.findByName(name);
        AuthorDto dto = authorMapper.convertToDto(entity);
        return dto;
    }

    @Override
    public List<AuthorDto> findListAuthorByName(String name) {
        List<AuthorEntity> albumEntityList = authorRepository.findListAuthorByName(name);
        List<AuthorDto> albumDtoList = authorMapper.convertListToDto(albumEntityList);
        return albumDtoList;
    }

    @Override
    public List<AuthorDto> listAllAuthorClient() {
        List<AuthorEntity> albumEntityList = authorRepository.listAllAlbumClient();
        List<AuthorDto> albumDtoList = authorMapper.convertListToDto(albumEntityList);
        return albumDtoList;
    }

    @Override
    public List<AuthorDto> findByNameClient(String name) {
        List<AuthorEntity> albumEntityList = authorRepository.findByNameClient(name);
        List<AuthorDto> albumDtoList = authorMapper.convertListToDto(albumEntityList);
        return albumDtoList;
    }

    @Override
    public long countAuthor() {
        return authorRepository.count();
    }
}
