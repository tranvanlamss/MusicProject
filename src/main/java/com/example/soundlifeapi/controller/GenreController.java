package com.example.soundlifeapi.controller;


import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.GenreDto;
import com.example.soundlifeapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    GenreService genreService;

    @GetMapping("/get-list")
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = genreService.getAllGenre(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }
    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = genreService.getAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all-genre-client")
    public ResponseEntity getAllGenreClient(){
        BaseResponse res = new BaseResponse();
        res.data = genreService.listAllGenreClient();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity getGenreByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data = genreService.findGenreByName(name);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-name-client/{name}")
    public ResponseEntity getGenreByNameClient(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data = genreService.findByNameClient(name);
        return ResponseEntity.ok(res);
    }

    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = genreService.getById(id);
        return ResponseEntity.ok(res);
    }
    @PostMapping("/create")
    public ResponseEntity createGenre(@RequestBody GenreDto genreDto){
        BaseResponse res = new BaseResponse<>();
        res.data = genreService.createGenre(genreDto);
        return  ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateGenre(@PathVariable("id") int id, @Valid @RequestBody GenreDto genreDto){
        BaseResponse res = new BaseResponse<>();
        GenreDto dto = genreService.getById(id);
        if (dto == null){
            throw new RuntimeException("id not found");
        }
        dto.setImage_url(dto.getImage_url());
        dto.setName(genreDto.getName());
        res.data = genreService.createGenre(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteGenre(@PathVariable("id") int id){
        genreService.deleteById(id);
        return ResponseEntity.ok("delete success");
    }
}
