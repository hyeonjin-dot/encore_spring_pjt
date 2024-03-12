package com.example.encore_spring_pjt.ctrl.valid.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.EmbeddableInstantiator;

@Getter
@Setter
@ToString
public class UserRequestDTO {
    private String name;
    private String password;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}", message = "핸드폰 번호 입력 양식을 맞춰주세요.")
    private String cellphone;
    @Min(value = 0, message = "진짜 나이를 입력하세요")
    @Max(value = 150, message = "진짜 나이를 입력하세요")
    private int age;
}
