package com.example.encore_spring_pjt.ctrl.jpa.ctrl;

import com.example.encore_spring_pjt.ctrl.jpa.domain.JpaEntity;
import com.example.encore_spring_pjt.ctrl.jpa.service.JpaService;
import com.example.encore_spring_pjt.domain.BoardResponse;
import com.example.encore_spring_pjt.service.BoardService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/jpa")
@RequiredArgsConstructor
public class JpaTestController {

    //의존성 주입 (service) - DI
    private final JpaService service;

    // 사용자의 모든 정보 조회 GetMapping
    @GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<JpaEntity>> list(){
        System.out.println("jpatestcontroller jpa/list");
        List<JpaEntity> list = service.findAll();
        return new ResponseEntity<List<JpaEntity>>(list, HttpStatus.OK);
    }

    //save
    @PostMapping(value = "/save")
    public ResponseEntity<JpaEntity> save(@RequestBody JpaEntity params){
        System.out.println("jpatestcontroller jpa/save");
        JpaEntity res = service.save(params);
        System.out.println(res);
        return new ResponseEntity<JpaEntity>(res, HttpStatus.OK);
    }

    //delete - pathVariable
    @DeleteMapping("/delete/{seq}")
    public ResponseEntity<Void> delete(@PathVariable("seq") Integer seq){
        System.out.println("jpatestcontroller jpa/delete");
        service.delete(seq);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}