package com.example.encore_spring_pjt.service;

import java.util.List;
import java.util.Optional;

import com.example.encore_spring_pjt.ctrl.rest.dao.PostRepository;
import com.example.encore_spring_pjt.domain.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.encore_spring_pjt.domain.BoardRequest;
import com.example.encore_spring_pjt.domain.BoardResponse;
import com.example.encore_spring_pjt.mapper.BoardMapper;

@Service
@RequiredArgsConstructor
public class PostServiceImpl {

    public final PostRepository postRepository;

    public Integer saveBoard(BoardRequest params) {
        System.out.println("debug >>>> post service saveBoard : " );
        return null;
    }

    public Optional<BoardResponse> findBoard(BoardRequest params) {
        // TODO Auto-generated method stub
        return null;
    }

    public Integer deleteBoard(BoardRequest params) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<BoardEntity> listBoard() {
        System.out.println("debug >>>> postService listboard : " + postRepository);
        return postRepository.findAll();
    }

    public Integer updateBoard(BoardRequest params) {
        // TODO Auto-generated method stub
        return null;
    }

    public Integer cntBoard() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
