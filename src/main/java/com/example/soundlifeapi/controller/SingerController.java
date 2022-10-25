package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.RoleDto;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.service.RoleService;
import com.example.soundlifeapi.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    SingerService singerService;

    @GetMapping("/get-list")
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = singerService.getAllSinger(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = singerService.getAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/find-name-client/{name}")
    public ResponseEntity findByNameClient(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse();
        res.data = singerService.findByNameClient(name);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all-singer-client")
    public ResponseEntity getAllSinger(){
        BaseResponse res = new BaseResponse();
        res.data = singerService.listAllSingerClient();
        return ResponseEntity.ok(res);
    }
    @GetMapping("/get-name/{name}")
    public ResponseEntity getByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data =singerService.findByName(name);
        return ResponseEntity.ok(res);
    }
    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = singerService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create")
    public ResponseEntity createSinger(@Valid @RequestBody SingerDto singerDto){
        BaseResponse res = new BaseResponse<>();
        res.data = singerService.create(singerDto);
        return  ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateSinger(@PathVariable("id") int id, @Valid @RequestBody SingerDto singerDto){
        BaseResponse res = new BaseResponse<>();
        SingerDto dto = singerService.getById(id);
        if (dto == null){
            throw new RuntimeException("id not found");
        }
        dto.setImage(singerDto.getImage());
        dto.setName(singerDto.getName());
        res.data = singerService.create(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteSinger(@PathVariable("id") int id){
        singerService.deleteById(id);
        return ResponseEntity.ok("delete success");
    }
}
