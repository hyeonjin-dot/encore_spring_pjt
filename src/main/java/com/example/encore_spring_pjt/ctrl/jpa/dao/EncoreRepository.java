package com.example.encore_spring_pjt.ctrl.jpa.dao;

import com.example.encore_spring_pjt.ctrl.jpa.domain.JpaEntity;
import com.example.encore_spring_pjt.ctrl.jpa.service.JpaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncoreRepository extends JpaRepository<JpaEntity, Integer> {

}
