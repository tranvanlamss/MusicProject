package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.PlaylistDto;
import com.example.soundlifeapi.dto.SongDto;
import com.example.soundlifeapi.service.LikeSongService;
import com.example.soundlifeapi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    SongService songService;

    @Autowired
    LikeSongService likeSongService;
    @GetMapping("/get-list")
    public ResponseEntity getAllSong(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = songService.getAllSong(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = songService.getAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all-song-client")
    public ResponseEntity getAllSongClient(){
        BaseResponse res = new BaseResponse();
        res.data = songService.listAllSongClient();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-song-by-singer_id/{singer_id}")
    public ResponseEntity getAll(@PathVariable("singer_id") int singer_id){
        BaseResponse res = new BaseResponse();
        res.data = songService.getAllBySingerId(singer_id);
        return ResponseEntity.ok(res);
    }
    @GetMapping("/get-name/{name}")
    public ResponseEntity getSongByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data = songService.findSongByName(name);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-list-song-name/{name}")
    public ResponseEntity getListSongByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data = songService.findListSongByName(name);
        return ResponseEntity.ok(res);
    }
    @GetMapping("/find-name-client/{name}")
    public ResponseEntity findByNameClient(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse();
        res.data = songService.findByNameClient(name);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create")
    public ResponseEntity createSong(@Valid @RequestBody SongDto songDto){
        BaseResponse res = new BaseResponse<>();
        res.data = songService.createSong(songDto);
        return  ResponseEntity.ok(res);
    }
    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = songService.getById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("get-album-id/{album_id}")
    public ResponseEntity getByAlbumId(@PathVariable("album_id") int album_id){
        BaseResponse res = new BaseResponse<>();
        res.data = songService.getAllBySingerId(album_id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("get-top-id/{top_id}")
    public ResponseEntity getByTopId(@PathVariable("top_id") int top_id){
        BaseResponse res = new BaseResponse<>();
        res.data = songService.getAllByTopId(top_id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("get-genre-id/{genre_id}")
    public ResponseEntity getByGenreId(@PathVariable("genre_id") int genre_id){
        BaseResponse res = new BaseResponse<>();
        res.data = songService.findSongByGenreId(genre_id);
        return ResponseEntity.ok(res);
    }


    @GetMapping("get-author-id/{author_id}")
    public ResponseEntity getByAuthorId(@PathVariable("author_id") int author_id){
        BaseResponse res = new BaseResponse<>();
        res.data = songService.findSongByAuthorId(author_id);
        return ResponseEntity.ok(res);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateSong(@PathVariable("id") int id, @Valid @RequestBody SongDto songDto){
        BaseResponse res = new BaseResponse<>();
        SongDto dto = songService.getById(id);
        if (dto == null){
            throw new RuntimeException("id not found");
        }
        dto.setName(songDto.getName());
        dto.setSinger_id(songDto.getSinger_id());
        dto.setAuthor_id(songDto.getAuthor_id());
        dto.setLyrics(songDto.getLyrics());
        dto.setTop_id(songDto.getTop_id());
        dto.setAlbum_id(songDto.getAlbum_id());
        dto.setGenre_id(songDto.getGenre_id());
        res.data = songService.createSong(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteSong(@PathVariable("id") int id){
        songService.deleteById(id);
        return ResponseEntity.ok("delete success");
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
