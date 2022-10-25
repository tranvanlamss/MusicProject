package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.CommentSongDto;
import com.example.soundlifeapi.dto.SongDto;
import com.example.soundlifeapi.service.CommentSongService;
import com.example.soundlifeapi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/comment-song")
public class CommentSongController {
    @Autowired
    CommentSongService commentSongService;

    @Autowired
    SongService songService;
    @GetMapping("/get-list")
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = commentSongService.getAllCommentSong(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = commentSongService.getAll();
        return ResponseEntity.ok(res);
    }
    @GetMapping("/get-all-comment-client")
    public ResponseEntity getAllCommentClient(){
        BaseResponse res = new BaseResponse();
        res.data = commentSongService.listAllCommentSongClient();
        return ResponseEntity.ok(res);
    }
    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = commentSongService.getById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("get-comment-id/{song_id}")
    public ResponseEntity findBySongId(@PathVariable("song_id") int song_id){
        BaseResponse res = new BaseResponse<>();
        res.data = commentSongService.findCommentSong(song_id);
        return ResponseEntity.ok(res);
    }
    @PostMapping("/create/{id}")
    public ResponseEntity createCommentSong(@Valid @RequestBody CommentSongDto commentSongDto, @PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        SongDto songDto = songService.getById(id);
        if (songDto == null){
            throw new RuntimeException("song not found");
        }
        commentSongDto.setSong_id(songDto.getId());
        res.data = commentSongService.createCommentSong(commentSongDto);
        return  ResponseEntity.ok(res);
    }


    @PutMapping("update/{id}")
    public ResponseEntity updateCommentSong(@PathVariable("id") int id, @RequestBody CommentSongDto commentSongDto ){
        BaseResponse res = new BaseResponse<>();
        CommentSongDto dto = commentSongService.getById(id);
        if (dto == null){
            throw new RuntimeException("id not found");
        }
        dto.setDescription(commentSongDto.getDescription());
        dto.setSong_id(commentSongDto.getSong_id());
        res.data = commentSongService.createCommentSong(dto);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id){
        commentSongService.deleteById(id);
        return ResponseEntity.ok("deleted success");
    }
    @GetMapping("/count/{song_id}")
    public ResponseEntity countLikeSong(@PathVariable("song_id") int song_id){
        int count = commentSongService.countComment(song_id);
        return ResponseEntity.ok(count);
    }
}
