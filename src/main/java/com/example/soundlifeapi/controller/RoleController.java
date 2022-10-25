package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.RoleDto;
import com.example.soundlifeapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/get-list")
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = roleService.getAllRole(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = roleService.getAll();
        return ResponseEntity.ok(res);
    }
    @GetMapping("/get-name/{name}")
    public ResponseEntity getRoleByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data =roleService.findRoleByName(name);
        return ResponseEntity.ok(res);
    }
    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = roleService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create")
    public ResponseEntity createSong(@Valid @RequestBody RoleDto roleDto){
        BaseResponse res = new BaseResponse<>();
        res.data = roleService.createRole(roleDto);
        return  ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRole(@PathVariable("id") int id, @Valid @RequestBody RoleDto roleDto){
        BaseResponse res = new BaseResponse<>();
        RoleDto dto = roleService.getById(id);
        if (dto == null){
            throw new RuntimeException("id not found");
        }
        dto.setName(roleDto.getName());
        res.data = roleService.createRole(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteRole(@PathVariable("id") int id){
        roleService.deleteById(id);
        return ResponseEntity.ok("delete success");
    }
}
