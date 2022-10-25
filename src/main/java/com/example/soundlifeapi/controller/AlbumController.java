package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.AlbumDto;
import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping("/get-list")
    public ResponseEntity getAllAlbum(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                      @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse();
        res.data = albumService.getAllAlbum(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

//    @GetMapping("/get-count")
//    public  ResponseEntity getCountAlbum(){
//        BaseResponse res = new BaseResponse();
//        res.data = albumService.;
//        return ResponseEntity.ok(res);
//    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = albumService.getAll();
        return ResponseEntity.ok(res);
    }
    @GetMapping("/get-all-album-client")
    public ResponseEntity getAllAlbumClient(){
        BaseResponse res = new BaseResponse();
        res.data = albumService.listAllAlbumClient();
        return ResponseEntity.ok(res);
    }
    @GetMapping("/find-by-name-client/{name}")
    public ResponseEntity getByNameClient(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse();
        res.data = albumService.findListAlbumByName(name);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-list-name/{name}")
    public ResponseEntity getAllByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse();
        res.data = albumService.findListAlbumByName(name);
        return ResponseEntity.ok(res);
    }
    @GetMapping("/get-name/{name}")
    public ResponseEntity findByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data = albumService.findAlbumByName(name);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create")
    public ResponseEntity getCreateAlbum(@RequestBody AlbumDto albumDto ){
        BaseResponse res = new BaseResponse();
        res.data = albumService.createAlbum(albumDto);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-id/{id}")
    public  ResponseEntity getAlbumById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse();
        res.data = albumService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAlbum(@Valid @PathVariable("id") int id, @RequestBody AlbumDto albumDto){
        BaseResponse res = new BaseResponse();
        AlbumDto dto = albumService.getById(id);
        if (dto == null){
            throw new RuntimeException("id not found");
        }
        dto.setName(albumDto.getName());
        dto.setAlbum_art(albumDto.getAlbum_art());
        dto.setLyric(albumDto.getLyric());
        res.data = albumService.createAlbum(dto);
        return ResponseEntity.ok(res);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteAlbum(@PathVariable("id") int id){
        albumService.deleteById(id);
       return ResponseEntity.ok("deleted success");
    }



}
