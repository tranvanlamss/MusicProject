package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.SingerDto;
import com.example.soundlifeapi.dto.TopDto;
import com.example.soundlifeapi.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/top")
public class TopController {

    @Autowired
    TopService topService;

    @GetMapping("/get-list")
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = topService.getAllTop(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = topService.getAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all-top-client")
    public ResponseEntity getAllTop(){
        BaseResponse res = new BaseResponse();
        res.data = topService.listAllTopClient();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity getByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data =topService.findByName(name);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-name-client/{name}")
    public ResponseEntity getByNameClient(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data =topService.findByNameClient(name);
        return ResponseEntity.ok(res);
    }

    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = topService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create")
    public ResponseEntity createTop(@Valid @RequestBody TopDto topDto){
        BaseResponse res = new BaseResponse<>();
        res.data = topService.create(topDto);
        return  ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTop(@PathVariable("id") int id, @Valid @RequestBody TopDto topDto){
        BaseResponse res = new BaseResponse<>();
        TopDto dto = topService.getById(id);
        if (dto == null){
            throw new RuntimeException("id not found");
        }
        dto.setName(topDto.getName());
        res.data = topService.create(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTop(@PathVariable("id") int id){
        topService.deleteById(id);
        return ResponseEntity.ok("delete success");
    }
}
