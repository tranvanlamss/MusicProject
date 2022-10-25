package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.MvDto;
import com.example.soundlifeapi.service.MvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mv")
public class MvController {
    @Autowired
    MvService mvService;

    @GetMapping("/get-list")
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = mvService.getAllMv(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = mvService.getAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all-mv-client")
    public ResponseEntity getAllMvClient(){
        BaseResponse res = new BaseResponse();
        res.data = mvService.listAllMvClient();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity getMvByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data = mvService.findMvByName(name);
        return ResponseEntity.ok(res);
    }
    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = mvService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create")
    public ResponseEntity createMv(MvDto mvDto){
        BaseResponse res = new BaseResponse<>();

        res.data = mvService.createMv(mvDto);
        return  ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMv(@PathVariable("id") int id, @Valid @RequestBody MvDto mvDto){
        BaseResponse res = new BaseResponse<>();
        MvDto dto = mvService.getById(id);
        if (dto == null){
            throw new RuntimeException("id not found");
        }

        dto.setName(mvDto.getName());
        dto.setThumbnail(mvDto.getThumbnail());
        dto.setVideo_url(mvDto.getVideo_url());
        res.data = mvService.createMv(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteMv(@PathVariable("id") int id){
        mvService.deleteById(id);
        return ResponseEntity.ok("delete success");
    }

}
