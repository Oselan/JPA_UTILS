package com.oselan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oselan.jpa_utils.repository.ExtendedRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class JpaUtilsApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(JpaUtilsApplication.class, args);
	}

	@Autowired
	@Qualifier("extendedRepositoryImpl")
	ExtendedRepository extendedRepository;
 
	@Override
	public void run(String... args) throws Exception {
		log.info("Testing extended Repository.. .by calling procedure");
		 
		extendedRepository.callProcedure("raise_notice_check");
		Thread.sleep(1000);
//		userRepository.callProcedure();
	}
}
