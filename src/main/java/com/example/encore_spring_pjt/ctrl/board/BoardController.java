package com.example.encore_spring_pjt.ctrl.board;

import com.example.encore_spring_pjt.domain.BoardRequest;
import com.example.encore_spring_pjt.domain.BoardResponse;
import com.example.encore_spring_pjt.service.BoardService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board") //http://serverip:port/board
public class BoardController {

    @Resource(name = "board")
    private BoardService service;

    @RequestMapping("/list.hanwha")
    public String list(){
        System.out.println("debug BoardController client path /board/list.hanwha");

        List<BoardResponse> lst = service.listBoard();
        for (BoardResponse response : lst){
            System.out.println(response);
        }

        /*
        BoardServiceImpl listBoard()메서드 호출하여 결과를 반환받고
        반환 받은 결과를 model(requestScope) 심고 이 데이터를
        forward 되는 페이지에서 출력
         */

        return "list";
    }

    @GetMapping("/view.hanwha")
    public String view(BoardRequest params, Model model){
    //public String view(@PathVariable("idx") Integer idx){
        System.out.println("debug BoardController client path /board/view.hanwha");
        System.out.println("params value , " + params.getIdx());
        //System.out.println("path value , " + idx);

        BoardResponse response = service.findBoard(params);
        model.addAttribute("response", response);

        /*
        view로부터 idx 값을 전달받고 객체로 바인딩되서 서비스에게 전달
        response 객체를 반환받고 해당 response 객체를 model에 심어서 뷰 페이지로 전달하는 과정
        */

        return "view";
    }

    @GetMapping("/write.hanwha")
    public String writeForm(BoardRequest params){
        System.out.println("debug BoardController client path /board/write.hanwha");

        service.saveBoard(params); // 아니던ㄷㅔ

        return "write";
    }
}