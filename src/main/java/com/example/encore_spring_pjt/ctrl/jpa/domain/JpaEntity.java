package com.example.encore_spring_pjt.ctrl.jpa.domain;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ENCORE_JPA_TEST_TBL")
public class JpaEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer seq;
    @Column
    private String id;
    @Column
    private String pwd;
    @Column
    private String name;


}
