package com.example.soundlifeapi.service;
import com.example.soundlifeapi.dto.CommentSongDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.entity.CommentSongEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommentSongService {
    List<CommentSongDto> getAll();
    List<CommentSongDto> getAllCommentSong(Pageable pageable);
    CommentSongDto createCommentSong(CommentSongDto commentSongDto);
    CommentSongDto getById(int id);
    void deleteById(int id);
    List<CommentSongDto> listAllCommentSongClient();
    int countComment(@Param("song_id") int song_id);
    List<CommentSongDto> findCommentSong(@PathVariable("song_id") int song_id);
}
