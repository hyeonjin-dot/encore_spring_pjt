package com.example.encore_spring_pjt.ctrl.board;

import com.example.encore_spring_pjt.domain.BoardEntity;
import com.example.encore_spring_pjt.service.PostServiceImpl;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post_jpa")
@RequiredArgsConstructor
public class BoardJpaController {

    private final PostServiceImpl postService;

    // 전체 조회
    @GetMapping(value = "/list", produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<List<BoardEntity>> list() {
        System.out.println("debug >>>> BoardJpaController client path : /board/jpa/list");
        List<BoardEntity> list = postService.listBoard();

        return new ResponseEntity<List<BoardEntity>>(list, HttpStatus.OK);
    }

}
