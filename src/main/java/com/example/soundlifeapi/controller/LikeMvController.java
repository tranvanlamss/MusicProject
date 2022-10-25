package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.LikeMvDto;
import com.example.soundlifeapi.dto.MvDto;
import com.example.soundlifeapi.service.LikeMvService;
import com.example.soundlifeapi.service.MvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/like-mv")
public class LikeMvController {
    @Autowired
    LikeMvService likeMvService;

    @Autowired
    MvService mvService;

    @GetMapping("/get-list")
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = likeMvService.getAllLikeMv(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = likeMvService.getAll();
        return ResponseEntity.ok(res);
    }
    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = likeMvService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create/{id}")
    public ResponseEntity createLikeMv(@Valid @RequestBody LikeMvDto likeMvDto, @PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        MvDto mvDto = mvService.getById(id);
        if (mvDto == null){
            throw new RuntimeException("mv not found");
        }
        likeMvDto.setMv_id(mvDto.getId());
        res.data = likeMvService.createLikeMv(likeMvDto);
        return  ResponseEntity.ok(res);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLikeMv(@PathVariable("id") int id){
        likeMvService.deleteById(id);
        return ResponseEntity.ok("delete success");
    }

    @GetMapping("/count/{mv_id}")
    public ResponseEntity countLikeSong(@PathVariable("mv_id") int mv_id){
        int count = likeMvService.countLike(mv_id);
        return ResponseEntity.ok(count);
    }
}
