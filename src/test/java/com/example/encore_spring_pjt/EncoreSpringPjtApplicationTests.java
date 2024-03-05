package com.example.encore_spring_pjt;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class EncoreSpringPjtApplicationTests {

	@Autowired
	private ApplicationContext context;

	// SqlSessionFactory (DI)
	@Autowired
	private SqlSessionFactory factory;

	@Test
	void contextLoads() {
	}

	@Test
	void testContext() {
		try {
			System.out.println("print : " + context.getBean("encore")); // bean에 할당된 이름을 찾는 것
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
