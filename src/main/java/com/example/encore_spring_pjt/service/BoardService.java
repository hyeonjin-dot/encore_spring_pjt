package com.example.encore_spring_pjt.service;

import java.util.List;

import com.example.encore_spring_pjt.domain.BoardRequest;
import com.example.encore_spring_pjt.domain.BoardResponse;

public interface BoardService {

    public Integer saveBoard(BoardRequest params);
    public BoardResponse findBoard(BoardRequest params);
    public Integer updateBoard(BoardRequest params);
    public Integer deleteBoard(BoardRequest params);
    public List<BoardResponse> listBoard();
    public Integer cntBoard();


}
    

