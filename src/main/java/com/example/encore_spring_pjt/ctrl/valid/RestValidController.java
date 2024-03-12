package com.example.encore_spring_pjt.ctrl.valid;

import com.example.encore_spring_pjt.ctrl.valid.domain.UserRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/valid")
public class RestValidController {


    // json {key:value, key:value, ... } 데이터 전달이 되었을 때를 가정
    // BindingResult : 유효성 검증에 실패한 메세지를 모아서 관리하는 객체
    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody UserRequestDTO params,
                                                 BindingResult bindingResult){
        System.out.println("debug postMethodName client path /valid/create");
        System.out.println("debug >>>" + params );

        /*if (params.getAge() > 200){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(params);
        }*/

        if (bindingResult.hasErrors()){
            System.out.println("error msg");
            //StringBuffer buffer = new StringBuffer();
            List<ObjectError> list = bindingResult.getAllErrors();
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++){
                String msg = list.get(i).getDefaultMessage();
                FieldError field = (FieldError)list.get(i);
                System.out.println("filed : " + field.getField() + "\t" + msg);
                map.put(field.getField(), msg);
            }
            return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
        }else {
            System.out.println("no error");
        }

        return new ResponseEntity(params, HttpStatus.OK);
    }

}
