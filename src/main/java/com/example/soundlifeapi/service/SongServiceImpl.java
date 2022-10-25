package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.SongDto;
import com.example.soundlifeapi.entity.SongEntity;
import com.example.soundlifeapi.mapper.SongMapper;
import com.example.soundlifeapi.repository.LikeSongRepository;
import com.example.soundlifeapi.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongServiceImpl implements SongService{
    @Autowired
    SongRepository songRepository;

    @Autowired
    SongMapper songMapper;

    @Autowired
    LikeSongService likeSongService;

    @Autowired
    LikeSongRepository likeSongRepository;

    @Override
    public List<SongDto> getAllSong(Pageable pageable) {
        List<SongEntity> entityList = songRepository.findAll(pageable).getContent();
        List<SongDto> dtoList = songMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public List<SongDto> getAll() {
        List<SongEntity> entityList = songRepository.findAll();
        List<SongDto> dtoList = songMapper.convertListToDto(entityList);
        return dtoList;
    }


    @Override
    public SongDto createSong(SongDto songDto) {
        SongEntity songEntityConvert = songMapper.convertToEntity(songDto);
        SongEntity songEntity = songRepository.save(songEntityConvert);
        SongDto dto = songMapper.convertToDto(songEntity);
        return dto;
    }

    @Override
    public SongDto getById(int id) {
        SongEntity songEntity = songRepository.findById(id).get();
        SongDto songDto = songMapper.convertToDto(songEntity);
        return songDto;

    }

    @Override
    public void deleteById(int id) {
        songRepository.deleteById(id);
    }

    @Override
    public SongDto findSongByName(String name) {
        SongEntity entity = songRepository.findSongByName(name);
        SongDto dto = songMapper.convertToDto(entity);
        return dto;
    }

    @Override
    public List<SongDto> findSongByAlbumId(int album_id) {
        List<SongEntity> entityList = songRepository.getAllByAlbumId(album_id);
        List<SongDto> dtoList = songMapper.convertListToDto(entityList);
        return dtoList;
    }


    @Override
    public List<SongDto> getAllBySingerId(int singer_id) {
        List<SongEntity> entityList = songRepository.getAllBySingerId(singer_id);
        List<SongDto> dtoList = songMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public List<SongDto> getAllByTopId(int top_id) {
        List<SongEntity> entityList = songRepository.getAllByTopId(top_id);
        List<SongDto> dtoList = songMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public List<SongDto> findSongByAuthorId(int author_id) {
        List<SongEntity> entityList = songRepository.getAllByAuthorId(author_id);
        List<SongDto> dtoList = songMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public List<SongDto> findSongByGenreId(int genre_id) {
        List<SongEntity> entityList = songRepository.getAllByGenreId(genre_id);
        List<SongDto> dtoList = songMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public List<SongDto> findListSongByName(String name) {
        List<SongEntity> entityList = songRepository.findListSongByName(name);
        List<SongDto> dtoList = songMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public List<SongDto> listAllSongClient() {
        List<SongEntity> entityList = songRepository.listAllSongClient();
        List<SongDto> dtoList = songMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public List<SongDto> findByNameClient(String name) {
        List<SongEntity> entityList = songRepository.findByNameClient(name);
        List<SongDto> dtoList = songMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public long countSong() {
        return songRepository.count();
    }


}
