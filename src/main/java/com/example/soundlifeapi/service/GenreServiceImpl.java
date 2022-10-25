package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.GenreDto;
import com.example.soundlifeapi.entity.GenreEntity;
import com.example.soundlifeapi.mapper.GenreMapper;
import com.example.soundlifeapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreServiceImpl implements GenreService{
    @Autowired
    GenreRepository genreRepository;

    @Autowired
    GenreMapper genreMapper;

    @Override
    public List<GenreDto> getAll() {
        List<GenreEntity> entityList = genreRepository.findAll();
        List<GenreDto> genreDtoList = genreMapper.convertListToDto(entityList);
        return genreDtoList;
    }

    @Override
    public List<GenreDto> getAllGenre(Pageable pageable) {
        List<GenreEntity> entityList = genreRepository.findAll(pageable).getContent();
        List<GenreDto> genreDtoList = genreMapper.convertListToDto(entityList);
        return genreDtoList;
    }

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        GenreEntity genreEntityConvert = genreMapper.convertToEntity(genreDto);
        GenreEntity genreEntity = genreRepository.save(genreEntityConvert);
        GenreDto dto = genreMapper.convertToDto(genreEntity);
        return dto;
    }

    @Override
    public GenreDto getById(int id) {
        GenreEntity genreEntity = genreRepository.findById(id).get();
        GenreDto genreDto = genreMapper.convertToDto(genreEntity);
        return genreDto;
    }

    @Override
    public void deleteById(int id) {
        genreRepository.deleteById(id);
    }

    @Override
    public GenreDto findGenreByName(String name) {
        GenreEntity entity = genreRepository.findGenreByName(name);
        GenreDto dto = genreMapper.convertToDto(entity);
        return dto;
    }

    @Override
    public List<GenreDto> findListGenreByName(String name) {
        List<GenreEntity> entityList = genreRepository.findListGenreByName(name);
        List<GenreDto> genreDtoList = genreMapper.convertListToDto(entityList);
        return genreDtoList;
    }

    @Override
    public List<GenreDto> listAllGenreClient() {
        List<GenreEntity> entityList = genreRepository.listAllGenreClient();
        List<GenreDto> genreDtoList = genreMapper.convertListToDto(entityList);
        return genreDtoList;
    }

    @Override
    public List<GenreDto> findByNameClient(String name) {
        List<GenreEntity> entityList = genreRepository.findByNameClient(name);
        List<GenreDto> genreDtoList = genreMapper.convertListToDto(entityList);
        return genreDtoList;
    }

    @Override
    public long countGenre() {
        return genreRepository.count();
    }
}
