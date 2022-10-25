package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/count")
public class DashboardController {

    @Autowired
    AlbumService albumService;

    @Autowired
    AuthorService authorService;

    @Autowired
    GenreService genreService;

    @Autowired
    SongService songService;

    @Autowired
    UserService userService;

    @Autowired
    SingerService singerService;

    @GetMapping("/get-count-album")
    public ResponseEntity getCountAlbum(){
        return ResponseEntity.ok(albumService.countAlbum());

    }
    @GetMapping("/get-count-author")
    public ResponseEntity getCountAuthor(){
        return ResponseEntity.ok(authorService.countAuthor());

    }
    @GetMapping("/get-count-genres")
    public ResponseEntity getCountGenre(){
        return ResponseEntity.ok(genreService.countGenre());

    }
    @GetMapping("/get-count-song")
    public ResponseEntity getCountSong(){
        return ResponseEntity.ok(songService.countSong());

    }
    @GetMapping("/get-count-user")
    public ResponseEntity getCountUser(){
        return ResponseEntity.ok(userService.countUser());

    }

    @GetMapping("/get-count-singer")
    public ResponseEntity getCountSinger(){
        return ResponseEntity.ok(singerService.countSinger());

    }
}
