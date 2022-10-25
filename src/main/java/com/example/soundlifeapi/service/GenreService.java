package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.GenreDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.GenreEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();
    List<GenreDto> getAllGenre(Pageable pageable);
    GenreDto createGenre(GenreDto genreDto);
    GenreDto getById(int id);
    void deleteById(int id);
    GenreDto findGenreByName(String name);
    List<GenreDto> findListGenreByName(String name);
    List<GenreDto> listAllGenreClient();
    List<GenreDto> findByNameClient(@PathVariable("name") String name);

    long countGenre();
}
