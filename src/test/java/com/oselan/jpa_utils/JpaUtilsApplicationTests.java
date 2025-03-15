package com.oselan.jpa_utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.oselan.jpa_utils.repository.ExtendedRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class JpaUtilsApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@Autowired
	@Qualifier("extendedRepositoryImpl")
	ExtendedRepository extendedRepository;
	
	
	@Test
	public void callingProcedure() throws Exception {
		log.info("Testing extended Repository.. .by calling procedure");
		 
		extendedRepository.callProcedure("raise_notice_check");
	 
//		userRepository.callProcedure();
	}
}
