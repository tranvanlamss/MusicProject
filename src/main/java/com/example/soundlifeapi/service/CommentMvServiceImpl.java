package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.CommentMvDto;
import com.example.soundlifeapi.dto.UserDto;
import com.example.soundlifeapi.entity.CommentMvEntity;
import com.example.soundlifeapi.mapper.CommentMvMapper;
import com.example.soundlifeapi.repository.CommentMvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentMvServiceImpl implements CommentMvService{
    @Autowired
    CommentMvRepository commentMvRepository;

    @Autowired
    CommentMvMapper commentMvMapper;

    @Autowired
    UserService userService;

    @Override
    public List<CommentMvDto> getAll() {
        List<CommentMvEntity> entityList = commentMvRepository.findAll();
        List<CommentMvDto> dtoList = commentMvMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public List<CommentMvDto> getAllCommentMv(Pageable pageable) {
        List<CommentMvEntity> entityList = commentMvRepository.findAll(pageable).getContent();
        List<CommentMvDto> dtoList = commentMvMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public CommentMvDto createCommentMv(CommentMvDto commentMvDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDto userDto = userService.findUserByName(username);
        commentMvDto.setUser_id(userDto.getId());
        CommentMvEntity commentMvEntityConvert = commentMvMapper.convertToEntity(commentMvDto);
        CommentMvEntity commentMvEntity = commentMvRepository.save(commentMvEntityConvert);
        CommentMvDto dto = commentMvMapper.convertToDto(commentMvEntity);
        return dto;
    }

    @Override
    public CommentMvDto getById(int id) {
        CommentMvEntity commentMvEntity = commentMvRepository.findById(id).get();
        CommentMvDto dto = commentMvMapper.convertToDto(commentMvEntity);

        return dto;
    }

    @Override
    public void deleteById(int id) {
        commentMvRepository.deleteById(id);
    }

    @Override
    public List<CommentMvDto> listAllCommentMvClient() {
        List<CommentMvEntity> entityList = commentMvRepository.listAllCommentMvClient();
        List<CommentMvDto> dtoList = commentMvMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public int countComment(int mv_id) {
        return commentMvRepository.countComment(mv_id);
    }
}
