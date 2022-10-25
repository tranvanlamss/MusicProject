package com.example.soundlifeapi.controller;


import com.example.soundlifeapi.dto.AuthorDto;
import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.UserDto;

import com.example.soundlifeapi.service.UserService;
import com.example.soundlifeapi.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class ApiController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;
    @Autowired
    JwtTokenUtils jwtTokenUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String token_json;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map authenticateUser(@Valid @RequestBody UserDto loginRequest, String s){
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenUtils.generateToken((User) authentication.getPrincipal()) ;

            return Collections.singletonMap("token", token);
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody UserDto userDto) {
        BaseResponse res = new BaseResponse<>();
        res.data = userService.registerUser(userDto);
        return ResponseEntity.ok(res);

    }

    @PostMapping("/register-admin")
    public ResponseEntity registerUserAdmin(@Valid @RequestBody UserDto userDto) {
        BaseResponse res = new BaseResponse<>();
        res.data = userService.registerUserAdmin(userDto);
        return ResponseEntity.ok(res);

    }
    @GetMapping("/get-by-user/{username}")
    public ResponseEntity getUser(@PathVariable("username") String username) {
        BaseResponse res = new BaseResponse<>();
        res.data = userService.findUserByName(username);
        return ResponseEntity.ok(res);

    }
    @GetMapping("/get-profile")
    public ResponseEntity getUserProfile() {
        BaseResponse res = new BaseResponse<>();
        res.data = userService.findUserProfile();
        return ResponseEntity.ok(res);

    }

    @GetMapping("/get-list")
    public ResponseEntity getAllUser(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                      @RequestParam(value = "limit", required = false, defaultValue = "5") String limit){
        BaseResponse res = new BaseResponse();
        res.data = userService.getAllUser(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable("id") int id, @Valid @RequestBody UserDto userDto){
        BaseResponse res = new BaseResponse<>();
        UserDto dto = userService.findUserById(id);
        if (dto == null){
            throw new RuntimeException("id not found");
        }
        dto.setUsername(userDto.getUsername());
        dto.setEmail(userDto.getEmail());
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        dto.setPassword(userDto.getPassword());
        res.data = userService.registerUser(dto);
        return ResponseEntity.ok(dto);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
