package com.example.encore_spring_pjt.mapper;

/*
encore_board_tbl 과 crud 작업을 위한 추상 메서드 선언
Mapper는 기존의 dao와 동일한 작업을 진행하는것
 */

import com.example.encore_spring_pjt.domain.BoardRequest;
import com.example.encore_spring_pjt.domain.BoardResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
public interface BoardMapper {
    //insert
    public void save(BoardRequest params);
    //select (single finder)
    public BoardResponse findByIdx(BoardRequest params);
    //update(title, content, writer) - idx
    public void updateByIdx(BoardRequest params);
    //레코드의 건수를 cnt
    public int count();
    //delete
    public void deleteByIdx(BoardRequest params);
    //select multi finder
    public List<BoardResponse> findAll();
    //조회수 증가
    public void updateByCnt(BoardRequest params);
}