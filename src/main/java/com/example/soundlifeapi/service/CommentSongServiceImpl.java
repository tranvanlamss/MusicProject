package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.CommentSongDto;
import com.example.soundlifeapi.dto.UserDto;
import com.example.soundlifeapi.entity.CommentSongEntity;
import com.example.soundlifeapi.mapper.CommentSongMapper;
import com.example.soundlifeapi.repository.CommentSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentSongServiceImpl implements CommentSongService{
    @Autowired
    CommentSongRepository commentSongRepository;
    @Autowired
    CommentSongMapper commentSongMapper;

    @Autowired
    UserService userService;

    @Override
    public List<CommentSongDto> getAll() {
        List<CommentSongEntity> entityList = commentSongRepository.findAll();
        List<CommentSongDto> dtoList = commentSongMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public List<CommentSongDto> getAllCommentSong(Pageable pageable) {
        List<CommentSongEntity> entityList = commentSongRepository.findAll(pageable).getContent();
        List<CommentSongDto> dtoList = commentSongMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public CommentSongDto createCommentSong(CommentSongDto commentSongDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDto userDto = userService.findUserByName(username);
        commentSongDto.setUser_id(userDto.getId());
        CommentSongEntity commentSongEntityConvert = commentSongMapper.convertToEntity(commentSongDto);
        CommentSongEntity commentSongEntity = commentSongRepository.save(commentSongEntityConvert);
        CommentSongDto dto = commentSongMapper.convertToDto(commentSongEntity);
        return dto;
    }

    @Override
    public CommentSongDto getById(int id) {
        CommentSongEntity commentSongEntity = commentSongRepository.findById(id).get();
        CommentSongDto dto = commentSongMapper.convertToDto(commentSongEntity);
        return dto;
    }

    @Override
    public void deleteById(int id) {
        commentSongRepository.deleteById(id);
    }

    @Override
    public List<CommentSongDto> listAllCommentSongClient() {
        List<CommentSongEntity> entityList = commentSongRepository.listAllCommentSongClient();
        List<CommentSongDto> dtoList = commentSongMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public int countComment(int song_id) {
        return commentSongRepository.countComment(song_id);
    }

    @Override
    public List<CommentSongDto> findCommentSong(int song_id) {
        List<CommentSongEntity> entityList = commentSongRepository.findCommentSongBySongId(song_id);
        List<CommentSongDto> dtoList = commentSongMapper.convertListToDto(entityList);
        return dtoList;
    }
}
