package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.SongDto;
import com.example.soundlifeapi.entity.SongEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SongService {
    List<SongDto> getAllSong(Pageable pageable);
    List<SongDto> getAll();
    SongDto createSong(SongDto songDto);
    SongDto getById(int id);
    void deleteById(int id);
    SongDto findSongByName(String name);
    List<SongDto> findSongByAlbumId(int album_id);
    List<SongDto> getAllBySingerId( int singer_id);
    List<SongDto> getAllByTopId( int top_id);
    List<SongDto> findSongByAuthorId(int author_id);
    List<SongDto> findSongByGenreId(int genre_id);

    List<SongDto> findListSongByName(String name);
    List<SongDto> listAllSongClient();
    List<SongDto> findByNameClient(String name);

    long countSong();
}
