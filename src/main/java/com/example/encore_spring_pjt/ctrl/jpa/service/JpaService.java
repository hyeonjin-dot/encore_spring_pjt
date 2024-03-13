package com.example.encore_spring_pjt.ctrl.jpa.service;

import com.example.encore_spring_pjt.ctrl.jpa.dao.EncoreRepository;
import com.example.encore_spring_pjt.ctrl.jpa.domain.JpaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<JpaEntity> find(int seq){
        System.out.println("jpaservice find");
        //Optional<JpaEntity> entity = encoreRepository.findById(seq);
        Optional<JpaEntity> entity = encoreRepository.findByCustromerId(seq);
        return entity;
    }

    //find - save
    public void update(JpaEntity entity){
        System.out.println("jpaservice find");
        //Optional<JpaEntity> entity = encoreRepository.findById(seq);
        Optional<JpaEntity> data = encoreRepository.findById(entity.getSeq());
        if(data.isPresent()){
            data.get().setSeq(entity.getSeq());
            data.get().setId(entity.getId());
            data.get().setPwd(entity.getPwd());
            data.get().setName(entity.getName());
            encoreRepository.save(entity);
        }
    }

    public List<JpaEntity> findByName(String name){
        System.out.println("jpaservice findByName");
        return encoreRepository.findByName(name);
    }

    public List<JpaEntity> findByNameLike(String name){
        System.out.println("jpaservice findByName");
        return encoreRepository.findByNameLike("%"+name+"%");
    }

    public void updateEntity(JpaEntity entity){
        System.out.println("jpaservice update");
        encoreRepository.updateEntity(entity.getSeq(), entity.getId(), entity.getPwd(), entity.getName());
    }
}
