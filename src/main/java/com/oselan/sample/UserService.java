package com.oselan.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService  {
 
	@Autowired
	private UserRepository userRepository;
	  
	public void callMyProcedure()  {

		log.info("calling procedure from another repo ... ");  
		try  {   
			userRepository.executeCallProcedure();
		} catch (Exception e) {
			log.error("Exception occured calling proc report", e);
			throw e;
		}
	}
}
