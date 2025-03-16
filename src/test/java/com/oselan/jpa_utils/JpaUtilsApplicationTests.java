package com.oselan.jpa_utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.oselan.jpa_utils.repository.ExtendedRepository;
import com.oselan.sample.UserService;

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
	
	@Autowired
	UserService userService;
	
	@Test
	public void callingProcedure() throws Exception {
		log.info("Testing extended Repository.. .by calling procedure");
		 
		extendedRepository.callProcedure("raise_notice_check");
	  
	}
	
	@Test
	public void callingProcedureIndirect() throws Exception {
		log.info("Testing extending repository.. .by calling procedure");
		 
		userService.callMyProcedure(); 
	}
	
	
}
