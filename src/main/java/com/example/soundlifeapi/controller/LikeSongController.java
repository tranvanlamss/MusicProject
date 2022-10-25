package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.LikeSongDto;
import com.example.soundlifeapi.dto.SongDto;
import com.example.soundlifeapi.service.LikeSongService;
import com.example.soundlifeapi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/like-song")
public class LikeSongController {
    @Autowired
    LikeSongService likeSongService;

   @Autowired
    SongService songService;

    @GetMapping("/get-list")
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = likeSongService.getAllLikeSong(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }
    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = likeSongService.getAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = likeSongService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLikeSong(@Valid @RequestBody LikeSongDto likeSongDto, @PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        SongDto songDto = songService.getById(id);
        if (songDto == null) {
            throw new RuntimeException("not found");
        }
        likeSongDto.setSong_id(songDto.getId());
        res.data = likeSongService.createLikeSong(likeSongDto);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteLikeSong(@PathVariable("id") int id){
        likeSongService.deleteById(id);
        return ResponseEntity.ok("delete success");
    }

    @GetMapping("/count/{song_id}")
    public ResponseEntity countLikeSong(@PathVariable("song_id") int song_id){
        int count = likeSongService.getCount(song_id);
        return ResponseEntity.ok(count);
    }

}
