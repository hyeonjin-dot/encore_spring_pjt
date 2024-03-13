package com.example.encore_spring_pjt.ctrl.jpa.ctrl;

import com.example.encore_spring_pjt.ctrl.jpa.domain.JpaEntity;
import com.example.encore_spring_pjt.ctrl.jpa.service.JpaService;
import com.example.encore_spring_pjt.domain.BoardRequest;
import com.example.encore_spring_pjt.domain.BoardResponse;
import com.example.encore_spring_pjt.service.BoardService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<Void> delete(@PathVariable("seq") Integer seq) {
        System.out.println("jpatestcontroller jpa/delete");
        service.delete(seq);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //find
    @GetMapping("/find/{seq}")
    public ResponseEntity<Optional<JpaEntity>> find(@PathVariable("seq") Integer seq){
        System.out.println("jpatestcontroller jpa/find");
        Optional<JpaEntity> res = service.find(seq);
        System.out.println(res);
        return new ResponseEntity<Optional<JpaEntity>>(res, HttpStatus.OK);
    }

    //기본키로 사용자 정보 수정
    @PutMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> update(@RequestBody JpaEntity entity){
        System.out.println("jpatestcontroller jpa/update");
        System.out.println(entity);
        service.update(entity);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "findName/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<JpaEntity>> find(@PathVariable("name") String name){
        System.out.println("jpatestcontroller jpa/find");
        List<JpaEntity> res = service.findByName(name);
        System.out.println(res);
        return new ResponseEntity<List<JpaEntity>>(res, HttpStatus.OK);
    }

    @GetMapping(value = "findByNameLike/{name}")
    public ResponseEntity<List<JpaEntity>> findLike(@PathVariable("name") String name){
        System.out.println("jpatestcontroller jpa/findLike");
        List<JpaEntity> res = service.findByNameLike(name);
        System.out.println(res);
        return new ResponseEntity<List<JpaEntity>>(res, HttpStatus.OK);
    }

    @PutMapping(value = "/updateEntity/{seq}/{id}/{pwd}/{name}")
    public ResponseEntity<JpaEntity> updateEntity(JpaEntity entity){
       System.out.println("jpatestcontroller jpa/updateEntity");
        service.updateEntity(entity);
       return new ResponseEntity<JpaEntity>(entity, HttpStatus.OK);
    }
}