package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.AuthorDto;
import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.RoleDto;
import com.example.soundlifeapi.service.AuthorService;
import com.example.soundlifeapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/get-list")
    public ResponseEntity getAll(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                 @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse<>();
        res.data = authorService.getAll(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = authorService.getAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all-author-client")
    public ResponseEntity getAllAuthorClient(){
        BaseResponse res = new BaseResponse();
        res.data = authorService.listAllAuthorClient();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity getByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data =authorService.findByName(name);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/find-by-name-client/{name}")
    public ResponseEntity getByNameClient(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data =authorService.findByNameClient(name);
        return ResponseEntity.ok(res);
    }
    @GetMapping("/get-list-author-name/{name}")
    public ResponseEntity getListAuthorByName(@PathVariable("name") String name){
        BaseResponse res = new BaseResponse<>();
        res.data =authorService.findListAuthorByName(name);
        return ResponseEntity.ok(res);
    }
    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = authorService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create")
    public ResponseEntity createAuthor(@Valid @RequestBody AuthorDto authorDto){
        BaseResponse res = new BaseResponse<>();
        res.data = authorService.create(authorDto);
        return  ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAuthor(@PathVariable("id") int id, @Valid @RequestBody AuthorDto authorDto){
        BaseResponse res = new BaseResponse<>();
        AuthorDto dto = authorService.getById(id);
        if (dto == null){
            throw new RuntimeException("id not found");
        }
        dto.setName(authorDto.getName());
        res.data = authorService.create(dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteAuthor(@PathVariable("id") int id){
        authorService.deleteById(id);
        return ResponseEntity.ok("delete success");
    }
}
