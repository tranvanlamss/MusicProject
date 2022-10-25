package com.example.soundlifeapi.service;

import com.example.soundlifeapi.entity.FileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileDBService {
    FileDB store(MultipartFile file) throws IOException;

    Stream<FileDB> getAllFiles();
    FileDB getById(String id) throws Exception;
}
