package com.example.encore_spring_pjt.ctrl.board;

import com.example.encore_spring_pjt.domain.BoardRequest;
import com.example.encore_spring_pjt.domain.BoardResponse;
import com.example.encore_spring_pjt.service.BoardService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board") // http://serverip:port/board
public class BoardController {
    @Resource(name="board")
    private BoardService service;

    @RequestMapping("/list.hanwha") // http://serverip:port/board/list.hanwha
    public String list(Model model) {
        System.out.println("debug BoardController client path /board/list.hanwha");

        List<BoardResponse> list = service.listBoard();
        for(BoardResponse response : list) {
            System.out.println(response);
        }
        model.addAttribute("lst", list);
        /*
         * BoardServiceImpl listBoard() 메서드 호출하여 결과를 반환받고
         * 반환받은 결과를 Model(RequestScope)에 심고 이 데이터를
         * forward 되는 페이지에서 출력
         */

        return "list";
    }

    //@GetMapping("/view.hanwha/{idx}")
    //public String view(@PathVariable("idx") Integer idx){
    @GetMapping("/view.hanwha")
    public String view(BoardRequest params, Model model) {
        System.out.println("debug BoardController client path /board/view.hanwha");
        System.out.println("params value, " + params.getIdx());

        /*
         * view로부터 키(idx)값을 전달받고 객체로 바인딩돼서 service에게 전달
         * response객체를 반환받달
         * 해당 response객체를 Model에 심어서 View페이지로 전달
         */
        Optional<BoardResponse> response = service.findBoard(params);
        model.addAttribute("response", response);

        return "view";
    }

    @GetMapping("/write.hanwha")
    public String writeForm(BoardRequest params, Model model) {
        System.out.println("debug BoardController client path GET /board/write.hanwha");
        System.out.println("debug >>>>> " + params);
        if(params.getIdx() != null) {
            System.out.println("debug >>>> update");
            Optional<BoardResponse> response = service.findBoard(params);
            model.addAttribute("response", response);
        }
        return "write";
    }

    @PostMapping("/write.hanwha")
    public String write(BoardRequest params) {
        System.out.println("debug BoardController client path POST /board/write.hanwha");
        System.out.println("debug >>> params value " + params);
        /*
         * params로 넘겨받은 데이터를 service에게 전달하여 Mapper(save)
         * 입력된 데이터의 기본키값을 반환받고 출력
         * 화면이동은 list로
         */

        Integer idx = service.saveBoard(params);
        System.out.println("debug result => " + idx + "번 게시글 입력");
        return "redirect:/board/list.hanwha";
    }

    @GetMapping("/delete.hanwha")
    public String delete(BoardRequest params) {
        System.out.println("debug BoardController client path GET/board/view.hanwha");
        System.out.println("debug >>> params value " + params);
        Integer idx = service.deleteBoard(params);
        System.out.println("debug result => " + idx + "번 게시글 삭제");
        return "redirect:/board/list.hanwha";
    }

    @PostMapping("/update.hanwha")
    public String update(BoardRequest params) {
        System.out.println("debug BoardController client path GET/board/view.hanwha");
        System.out.println("debug >>> params value " + params);
        Integer idx = service.updateBoard(params);
        System.out.println("debug result => " + idx + "번 게시글 수정");
        return "redirect:/list.hanwha";
    }

}