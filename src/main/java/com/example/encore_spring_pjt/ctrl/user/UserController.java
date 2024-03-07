package com.example.encore_spring_pjt.ctrl.user;

import com.example.encore_spring_pjt.ctrl.user.domain.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user") // http:// servre ip : port / user
public class UserController {
    @PostMapping("/login.hanwha") // http:// servre ip : port / user/login.hanwha
    public String login(UserRequest params) {

        System.out.println("debug UserController client path /user/login.hanwha");
        System.out.println("params value >>> " + params.getId());
        System.out.println("params value >>> " + params.getPwd());
        return "redirect:/board/list.hanwha"; //list.jsp 로 ㄱㄱ
    }

}

