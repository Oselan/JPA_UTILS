package com.oselan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.oselan.sample.UserService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableJpaRepositories(considerNestedRepositories = true,repositoryImplementationPostfix = "Impl")
public class JpaUtilsApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(JpaUtilsApplication.class, args);
	}
//	@Autowired
//    private PostgresNotificationListener notificationListener;
//	@Autowired
//	@Qualifier("extendedRepositoryImpl")
//	ExtendedRepository extendedRepository;
// 
	@Autowired
	UserService userService;
	@Override
	public void run(String... args) throws Exception {
//		log.info("Testing extended Repository.. .by calling procedure");
//		 
//		extendedRepository.callProcedure("raise_notice_check");
//		Thread.sleep(1000);
		userService.callMyProcedure();
//		notificationListener.listenForNotifications();
	}
	
	
 
}
