package com.example.encore_spring_pjt.ctrl.rest.dao;

import com.example.encore_spring_pjt.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<BoardEntity, Integer> {
    //JPA, JPQL
    //findxxx


}
