package com.example.encore_spring_pjt.ctrl;

import com.example.encore_spring_pjt.domain.BoardResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/*
    Http가 갖고 있는 코드에서 정상적으로 통신이 이루어진다면 200, error 발생시 404(not found), 405(bad request. get-post가 맞지 않는 경우)
    @RequestMapping을 상속받는 어노테이션
    -- GetMapping(<a herf="">)
    -- PostMapping(<form action="" method="get|post">)
    @RestController (json+async)
    @Controller (full browsing, rest API - @ResponseBody)
 */

//@Controller
public class TestController {
    /*
        http://server_ip:port/
        Controller method의 return type : void, String, ModelAndView -- full browsing 방식의 통신
        Controller method의 return type : xxxxDTO, List, Map, Set, ResponseEntity -- REST API service
     */

//    @RequestMapping("/")
//    public String index() {
//        System.out.println(">>>> TestController path /, callback function index()");
//        return "index";
//    }

//    @RequestMapping("/")
//    public ModelAndView index() {
//        System.out.println(">>>> TestController path /, callback function index()");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("index");
//        mv.addObject("msg", "hello JSP");
//        return mv;
//    }
/*
    @RequestMapping("/")
    public String index(Model model) {
        System.out.println(">>>> TestController path /, callback function index()");
        model.addAttribute("msg", "welcome to SpringBoot with JSP");
        return "index";
    }

    @RequestMapping(value = "/test")
    public void test() {
        System.out.println(">>>> TestController path /test, callback function test()");
    }

    @GetMapping("/json")
    @ResponseBody
    public List<BoardResponse> json() {
        System.out.println(">>>> TestController path /json, callback function json()");
        BoardResponse board = BoardResponse.builder().title("json data").content("content").writer("writer").build();
        List<BoardResponse> lst = new ArrayList<>();
        lst.add(board);
        lst.add(board);
        lst.add(board);
        return lst;
    }*/
}