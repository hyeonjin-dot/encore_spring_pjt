package com.example.encore_spring_pjt.ctrl.jpa.dao;

import com.example.encore_spring_pjt.ctrl.jpa.domain.JpaEntity;
import com.example.encore_spring_pjt.ctrl.jpa.service.JpaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EncoreRepository extends JpaRepository<JpaEntity, Integer> {

    /*
    - JAP - Update(find-save)
    사용자 정의 메서드를 정의해서 편하게 작업해 본다면? - JPQL
    @Query - Select
    @Query - DML(Insert, Update, Delete) with @Modifying
    @Param - :xxxx 데이터 바인딩
     */
    @Transactional
    @Modifying
    @Query("UPDATE ENCORE_JPA_TEST_TBL U "
            +"SET U.id=:id, U.pwd=:pwd, U.name=:name "
            +"WHERE U.seq=:seq")
    public void updateEntity(@Param("seq") Integer seq,
                                            @Param("id") String id,
                                            @Param("pwd") String pwd,
                                            @Param("name") String name);

    @Query("select u from ENCORE_JPA_TEST_TBL u where u.seq = :seq")
    public Optional<JpaEntity> findByCustromerId(@Param("seq") Integer seq);


//    findByXXXX 컬럼명(property)
//    findByPwd(), findByName(), findByNameLike(List<JpaEntity> findById(String id);
//    findByIdAndPwd(String id, String pwd) : where id = ? and pwd = ? ;
//    findByIdOrPwd(String id, String pwd) : where id = ? or pwd = ? ;
//    findByIdOrderByAsc() : 정렬 진행 가능

    public List<JpaEntity> findByName(String name);

    public List<JpaEntity> findByNameLike(String name);
}
