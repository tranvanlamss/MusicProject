package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.PlaylistDto;
import com.example.soundlifeapi.service.PlaylistService;
import com.example.soundlifeapi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    @Autowired
    PlaylistService playlistService;

    @Autowired
    SongService songService;
    @GetMapping("/get-list")
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = playlistService.getAllPlaylist(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }
    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = playlistService.getAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all-playlist-client")
    public ResponseEntity getAllPlaylistClient(){
        BaseResponse res = new BaseResponse();
        res.data = playlistService.listAllPlaylistClient();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity getPlaylistByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data = playlistService.findPlaylistByName(name);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-name-client/{name}")
    public ResponseEntity getPlaylistByNameClient(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data = playlistService.findByNameClient(name);
        return ResponseEntity.ok(res);
    }

    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = playlistService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create")
    public ResponseEntity createPlaylist(@Valid @RequestBody PlaylistDto playlistDto){
        BaseResponse res = new BaseResponse<>();
        res.data = playlistService.createPlaylist(playlistDto);
        return  ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePlaylist(@PathVariable("id") int id, @Valid @RequestBody PlaylistDto playlistDto){
        BaseResponse res = new BaseResponse<>();
        PlaylistDto dto = playlistService.getById(id);
        if (dto == null){
            throw new RuntimeException("id not found");
        }
        dto.setName(playlistDto.getName());
        dto.setImage_url(playlistDto.getImage_url());
        res.data = playlistService.createPlaylist(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("delete-song/{id}")
    public ResponseEntity deleteSong(@PathVariable("id") int id){
        songService.deleteById(id);
        return ResponseEntity.ok("delete song success");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deletePlaylist(@PathVariable("id") int id){
        songService.deleteById(id);
        return ResponseEntity.ok("delete success");
    }

}
