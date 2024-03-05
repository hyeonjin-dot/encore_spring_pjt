package com.example.encore_spring_pjt;

import com.example.encore_spring_pjt.domain.BoardRequest;
import com.example.encore_spring_pjt.domain.BoardResponse;
import com.example.encore_spring_pjt.mapper.BoardMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybaticsORMTests {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void ormSave(){
        System.out.println("debug >>>> " + boardMapper);
        BoardRequest boardRequest = new BoardRequest();
        boardRequest.setTitle("orm 수업");
        boardRequest.setContent("mybatis mapping");
        boardRequest.setWriter("encore");
        boardRequest.setNoticeYn(true);
        boardRequest.setSecretYn(true);
        boardMapper.save(boardRequest);
        System.out.println("debug >>>> save success");
    }

    @Test
    public void ormFind() throws Exception{
        System.out.println("debug finder >>>>>> ");
        BoardRequest request = new BoardRequest();
        request.setIdx(1);
        BoardResponse response = boardMapper.findByIdx(request);
        System.out.println("result >> " + response);
        String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(response);
        System.out.println(boardJson);
    }

    @Test
    public void ormUpdate(){
        System.out.println("debug >>>> ");
        BoardRequest boardRequest = new BoardRequest();
        boardRequest.setIdx(1);
        boardRequest.setTitle("new");
        boardRequest.setContent("new");
        boardRequest.setWriter("new");
        boardMapper.updateByIdx(boardRequest);
        System.out.println("debug >> update");
    }

    @Test
    public void ormCnt(){
        System.out.println("Count");
        System.out.println(boardMapper.count());
    }

    @Test
    public void ormDelete(){
        System.out.println("delete");
        BoardRequest boardRequest = new BoardRequest();
        boardRequest.setIdx(1);
        boardMapper.deleteByIdx(boardRequest);
    }

    @Test
    public void ormFindAll(){
        System.out.println("Find all");
        System.out.println(boardMapper.findAll());
    }

}
