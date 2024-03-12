package com.example.encore_spring_pjt.ctrl.jpa.service;

import com.example.encore_spring_pjt.ctrl.jpa.dao.EncoreRepository;
import com.example.encore_spring_pjt.ctrl.jpa.domain.JpaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaService {
    //jpa : dao(interface) - repository
    //mybatis : dao(interface) - mapper
    //의존성 주입으로 repository 받야야한다.
    @Autowired(required = true)
    private EncoreRepository encoreRepository;

    public List<JpaEntity> findAll(){
        System.out.println("jpaservice findAll");
        //repository call
        List<JpaEntity> list = encoreRepository.findAll();
//        for (JpaEntity e : list){
//            System.out.println(e.toString());
//        }
//        List<JpaEntity> list = new ArrayList<JpaEntity>();
//        encoreRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public JpaEntity save(JpaEntity params){
        System.out.println("jpaservice save");
        encoreRepository.save(params);
        return params;
    }

    public void delete(int seq){
        System.out.println("jpaservice delete");
        encoreRepository.deleteById(seq);
    }

}
