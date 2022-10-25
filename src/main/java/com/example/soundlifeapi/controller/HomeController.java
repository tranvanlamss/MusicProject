package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.service.AlbumService;
import com.example.soundlifeapi.service.PlaylistService;
import com.example.soundlifeapi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    SongService songService;

    @Autowired
    PlaylistService playlistService;

    @Autowired
    AlbumService albumService;

//    @GetMapping("/get-all-song")
//    public ResponseEntity getAllSong(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
//                                 @RequestParam(value = "limit", required = false, defaultValue = "8") String limit){
//        BaseResponse res = new BaseResponse<>();
//        res.data = songService.getAllSong(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
//        return ResponseEntity.ok(res);
//    }
//
//    @GetMapping("/get-all-song-sort")
//    public ResponseEntity getAllSongSort(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
//                                     @RequestParam(value = "limit", required = false, defaultValue = "8") String limit){
//        BaseResponse res = new BaseResponse<>();
//        res.data = songService.getAllSong(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit), Sort.by("id").descending()));
//        return ResponseEntity.ok(res);
//    }
//
//    @GetMapping("/get-all")
//    public ResponseEntity getAllAdd(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
//                                    @RequestParam(value = "limit", required = false, defaultValue = "24") String limit){
//        BaseResponse res = new BaseResponse<>();
//        res.data = songService.getAllSong(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
//        return ResponseEntity.ok(res);
//    }

    @GetMapping("/get-all-song-client")
    public ResponseEntity getAllSongClient(){
        BaseResponse res = new BaseResponse();
        res.data = songService.listAllSongClient();
        return ResponseEntity.ok(res);
    }
//    @GetMapping("/get-all-playlist")
//    public ResponseEntity getAllPlaylist(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
//                                 @RequestParam(value = "limit", required = false, defaultValue = "5") String limit){
//        BaseResponse res = new BaseResponse<>();
//        res.data = playlistService.getAllPlaylist(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
//        return ResponseEntity.ok(res);
//    }

    @GetMapping("/get-all-playlist-client")
    public ResponseEntity getAllPlaylistClient(){
        BaseResponse res = new BaseResponse<>();
        res.data = playlistService.listAllPlaylistClient();
        return ResponseEntity.ok(res);
    }

//    @GetMapping("/get-all-album")
//    public ResponseEntity getAllAlbum(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
//                                      @RequestParam(value = "limit", required = false, defaultValue = "5") String limit){
//        BaseResponse res = new BaseResponse();
//        res.data = albumService.getAllAlbum(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
//        return ResponseEntity.ok(res);
//    }

    @GetMapping("/get-all-album-client")
    public ResponseEntity getAllAlbumClient(){
        BaseResponse res = new BaseResponse();
        res.data = albumService.listAllAlbumClient();
        return ResponseEntity.ok(res);
    }
    @GetMapping("get-song-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = songService.getById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("get-song-name/{name}")
    public ResponseEntity getByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data = songService.findSongByName(name);
        return ResponseEntity.ok(res);
    }
}
