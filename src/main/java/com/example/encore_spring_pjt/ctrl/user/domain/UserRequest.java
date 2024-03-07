package com.example.encore_spring_pjt.ctrl.user.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserRequest {
    public String id;
    public String pwd;
}
