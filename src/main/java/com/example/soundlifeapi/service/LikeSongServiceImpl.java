package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.LikeSongDto;
import com.example.soundlifeapi.dto.SongDto;
import com.example.soundlifeapi.dto.UserDto;
import com.example.soundlifeapi.entity.LikeSongEntity;
import com.example.soundlifeapi.mapper.LikeSongMapper;
import com.example.soundlifeapi.repository.LikeSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeSongServiceImpl implements LikeSongService{
    @Autowired
    LikeSongRepository likeSongRepository;
    @Autowired
    LikeSongMapper likeSongMapper;

    @Autowired
    UserService userService;

    @Autowired
    SongService songService;


    @Override
    public List<LikeSongDto> getAll() {
        List<LikeSongEntity> entityList = likeSongRepository.findAll();
        List<LikeSongDto> dtoList = likeSongMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public List<LikeSongDto> getAllLikeSong(Pageable pageable) {

        List<LikeSongEntity> entityList = likeSongRepository.findAll(pageable).getContent();
        List<LikeSongDto> dtoList = likeSongMapper.convertListToDto(entityList);
        return dtoList;
    }

    @Override
    public LikeSongDto createLikeSong(LikeSongDto likeSongDto) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            UserDto userDto = userService.findUserByName(username);
            likeSongDto.setUser_id(userDto.getId());
            likeSongDto.setLike_song(1);
            LikeSongEntity likeSongEntityConvert = likeSongMapper.convertToEntity(likeSongDto);
            LikeSongEntity likeSongEntity = likeSongRepository.save(likeSongEntityConvert);
            LikeSongDto dto = likeSongMapper.convertToDto(likeSongEntity);
            return dto;
    }

    @Override
    public LikeSongDto getById(int id) {
        LikeSongEntity likeSongEntity = likeSongRepository.findById(id).get();
        LikeSongDto likeSongDto = likeSongMapper.convertToDto(likeSongEntity);
        return likeSongDto;
    }

    @Override
    public void deleteById(int id) {
        likeSongRepository.deleteById(id);
    }

    @Override
    public int getCount(int song_id) {
        int like = likeSongRepository.countLike(song_id);
        return like;
    }

    @Override
    public List<LikeSongDto> listAllLikeSongClient() {
        List<LikeSongEntity> entityList = likeSongRepository.listAllLikeSongClient();
        List<LikeSongDto> dtoList = likeSongMapper.convertListToDto(entityList);
        return dtoList;
    }


}
