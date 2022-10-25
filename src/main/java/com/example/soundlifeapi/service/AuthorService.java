package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.AuthorDto;
import com.example.soundlifeapi.entity.AuthorEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();
    List<AuthorDto> getAll(Pageable pageable);
    AuthorDto create(AuthorDto authorDto);
    AuthorDto getById(int id);
    void deleteById(int id);
    AuthorDto findByName(String name);
    List<AuthorDto> findListAuthorByName(String name);
    List<AuthorDto> listAllAuthorClient();
    List<AuthorDto> findByNameClient(@PathVariable("name") String name);

    long countAuthor();
}
