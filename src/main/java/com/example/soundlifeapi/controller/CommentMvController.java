package com.example.soundlifeapi.controller;

import com.example.soundlifeapi.dto.BaseResponse;
import com.example.soundlifeapi.dto.CommentMvDto;
import com.example.soundlifeapi.dto.MvDto;
import com.example.soundlifeapi.service.CommentMvService;
import com.example.soundlifeapi.service.MvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/comment-mv")
public class CommentMvController {
    @Autowired
    CommentMvService commentMvService;
    @Autowired
    MvService mvService;

    @GetMapping("/get-list")
    public ResponseEntity getList(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                  @RequestParam(value = "limit", required = false, defaultValue = "10") String limit){
        BaseResponse res = new BaseResponse();
        res.data = commentMvService.getAllCommentMv(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll(){
        BaseResponse res = new BaseResponse();
        res.data = commentMvService.getAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-all-comment-client")
    public ResponseEntity getAllCommentClient(){
        BaseResponse res = new BaseResponse();
        res.data = commentMvService.listAllCommentMvClient();
        return ResponseEntity.ok(res);
    }
    @GetMapping("get-id/{id}")
    public ResponseEntity getById(@PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        res.data = commentMvService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create/{id}")
    public ResponseEntity createCommentMv(@Valid @RequestBody CommentMvDto commentMvDto, @PathVariable("id") int id){
        BaseResponse res = new BaseResponse<>();
        MvDto mvDto = mvService.getById(id);
        if (mvDto == null){
            throw new RuntimeException("mv not found");
        }
        commentMvDto.setMv_id(mvDto.getId());
        res.data = commentMvService.createCommentMv(commentMvDto);
        return  ResponseEntity.ok(res);
    }

    @GetMapping("/get-comment-id/{id}")
    public  ResponseEntity getCommentMvById(@PathVariable("id") int id){
       BaseResponse res = new BaseResponse<>();
        res.data = commentMvService.getById(id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCommentMv(@PathVariable("id") int id, @Valid @RequestBody CommentMvDto commentMvDto){
        BaseResponse res = new BaseResponse<>();
        CommentMvDto dto = commentMvService.getById(id);
        if (dto == null){
            throw  new RuntimeException("comment not found");
        }
        dto.setDescription(commentMvDto.getDescription());
        dto.setMv_id(commentMvDto.getMv_id());
        res.data = commentMvService.createCommentMv(dto);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCommentMv(@PathVariable("id") int id){
        commentMvService.deleteById(id);
        return ResponseEntity.ok("deleted success");
    }

    @GetMapping("/count/{mv_id}")
    public ResponseEntity countCommentMv(@PathVariable("mv_id") int mv_id){
        int count = commentMvService.countComment(mv_id);
        return ResponseEntity.ok(count);
    }
}
