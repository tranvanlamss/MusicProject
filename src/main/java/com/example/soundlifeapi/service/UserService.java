package com.example.soundlifeapi.service;

import com.example.soundlifeapi.dto.AlbumDto;
import com.example.soundlifeapi.dto.UserDto;
import com.example.soundlifeapi.entity.AlbumEntity;
import com.example.soundlifeapi.entity.UserEntity;
import com.example.soundlifeapi.mapper.UserMapper;
import com.example.soundlifeapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null ){
            throw  new UsernameNotFoundException("not found");
        }
        SimpleGrantedAuthority grand = new SimpleGrantedAuthority(userEntity.getRole().getName());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(grand);
        User user = new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
        return user;
    }

    public UserDto registerUser(UserDto userDto){
        UserEntity userEntity1 = userRepository.findByUsername(userDto.getUsername());
        UserDto userDto1 = userMapper.convertToDto(userEntity1);
        if (userDto1 != null){
            throw new RuntimeException("username already");
        }

        userDto.setRole_id(1);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserEntity userEntityConvert = userMapper.convertToEntity(userDto);

        UserEntity userEntity = userRepository.save(userEntityConvert);
        UserDto dto = userMapper.convertToDto(userEntity);
        return dto;
    }

    public UserDto registerUserAdmin(UserDto userDto){
        UserEntity userEntity1 = userRepository.findByUsername(userDto.getUsername());
        UserDto userDto1 = userMapper.convertToDto(userEntity1);
        if (userDto1 != null){
            throw new RuntimeException("username already");
        }

        userDto.setRole_id(2);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserEntity userEntityConvert = userMapper.convertToEntity(userDto);

        UserEntity userEntity = userRepository.save(userEntityConvert);
        UserDto dto = userMapper.convertToDto(userEntity);
        return dto;
    }
    public UserDto findUserByName(String username){
        UserEntity userEntity = userRepository.findByUsername(username);
        UserDto userDto = userMapper.convertToDto(userEntity);
        return userDto;
    }

    public UserDto findUserById(int id){
        UserEntity userEntity = userRepository.findById(id).get();
        UserDto userDto = userMapper.convertToDto(userEntity);
        return userDto;
    }
    public UserDto findUserProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        UserEntity userEntity = userRepository.findByUsername(name);
        UserDto userDto = userMapper.convertToDto(userEntity);
        return userDto;
    }
    public List<UserDto> getAllUser(Pageable pageable) {
        List<UserEntity> entityList = userRepository.findAll(pageable).getContent();
        List<UserDto> dto = userMapper.convertListToDto(entityList);
        return dto;
    }


    public long countUser() {
        return userRepository.count();
    }
}
