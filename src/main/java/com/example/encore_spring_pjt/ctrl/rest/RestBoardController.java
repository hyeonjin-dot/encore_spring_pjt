package com.example.encore_spring_pjt.ctrl.rest;

import com.example.encore_spring_pjt.domain.BoardRequest;
import com.example.encore_spring_pjt.domain.BoardResponse;
import com.example.encore_spring_pjt.service.BoardService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/*
HTTP 통신 client가 웹 서버에게(was) 요청의 목적을 알리는 수단
- GET, POST, PUT, DELETE (CRUD)
- GET : Read (읽기 전용)
- POST : Update (새로운 자원 생성)
- PUT : Insert (새로운 자원 생성)
- DELETE : Delete (자원을 삭제)
- http:// serverip : port / board ? idx = 1

HTTP 응답코드의 상태코드
1xx(정보) : 요청이 성공했고, 서버는 프로세스를 계속 진행
2xx(성공) : 요청이 성공했고, 서버는 해당 요청을 수용
3xx(리다이렉트 오류) : 요청이 제대로 처리되지 않아서 재요청 작업이 필요
4xx(클라이언트 오류) : 요청 문법이 잘못되었거나 요청을 처리할 수 없을 때
5xx(서버 오류) : 요청에 대해서 실패(NPE)

RestController 통신을 위한 탬플릿이 제공(RequestEntity, ResponseEntity)
 */
@RestController
@RequestMapping("/board_rest")
public class RestBoardController {
    //DI - BoardServiceImpl
    @Resource(name = "board")
    private BoardService service;

    //조회
    @GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BoardResponse>> list(){
        System.out.println("RestboardController board_rest/list");
        List<BoardResponse> list = service.listBoard();
        return new ResponseEntity<List<BoardResponse>>(list, HttpStatus.OK);
    }

    //삭제
    @DeleteMapping(value = "/{idx}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> delete(@PathVariable("idx") Integer idx){
        System.out.println("restBoardController /board_rest/idx");
        BoardRequest request = BoardRequest.builder().idx(idx).build();
        Integer result = service.deleteBoard(request);
        System.out.println(result + "번 글 삭제 완료");
        request.setIdx(idx);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //게시글 번호로 조회
    @GetMapping(value = "/view/{idx}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<BoardResponse>> listIdx(@PathVariable("idx") Integer idx){
        System.out.println("restBoardController /view/idx");
        BoardRequest find = BoardRequest.builder().idx(idx).build();
        Optional<BoardResponse> res = service.findBoard(find);
        return new ResponseEntity<Optional<BoardResponse>>(res, HttpStatus.OK);
    }

    //게시글 번호로 수정
    /*@PutMapping(value = "/update/{idx}/{title}/{content}/{writer}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> updateIdx(@PathVariable("idx") Integer idx,
                                          @PathVariable("title") String title,
                                          @PathVariable("content") String content,
                                          @PathVariable("writer") String writer){
        System.out.println("restBoardController /update/idx/title/content/writer");
        BoardRequest find = BoardRequest.builder()
                                        .idx(idx)
                                        .title(title)
                                        .content(content)
                                        .writer(writer).build();
        Integer i = service.updateBoard(find);
        System.out.println(i + "번 글 업데이트");
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // void라 아무것도 없다는 것을 알려줌
    }*/
    //객체형식으로 테스트 진행
    @PutMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> updateIdx(BoardRequest params){
        System.out.println("restBoardController /update/idx/title/content/writer");
        Integer res = service.updateBoard(params);
        System.out.println(res + "번 글 업데이트");
        return null;
    }

    @PostMapping(value = "/write", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> insert(BoardRequest params){
        System.out.println("restBoardController /write");
        Integer res = service.saveBoard(params);
        System.out.println(res + "번 글 생성");
        Map<String, String> map = new HashMap<>();
        map.put("msg", res + "번 게시글 입력 완료");
        return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
    }
}
