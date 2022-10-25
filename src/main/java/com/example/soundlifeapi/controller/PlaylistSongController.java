package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.PlaylistSongDto;
import com.example.soundlifeapi.dto.RoleDto;
import com.example.soundlifeapi.dto.SongDto;
import com.example.soundlifeapi.service.PlaylistSongService;
import com.example.soundlifeapi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pivot")
public class PlaylistSongController {

    @Autowired
    PlaylistSongService playlistSongService;

    @Autowired
    SongService songService;

    @PostMapping("/create/{song_id}")
    public ResponseEntity create(@RequestBody PlaylistSongDto playlistSongDto, @PathVariable("song_id") int song_id){
        BaseResponse res = new BaseResponse<>();
        SongDto song = songService.getById(song_id);

        playlistSongDto.setSong_id(song.getId());
        res.data = playlistSongService.createPlaylistSong(playlistSongDto);
        return  ResponseEntity.ok(res);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSong(@PathVariable("id") int id){
        playlistSongService.deleteBySongId(id);
        return ResponseEntity.ok("delete success");
    }

    @GetMapping("/get-list")
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = playlistSongService.getAllPlaylistSong(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }
}
