package com.oselan.sample;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oselan.jpa_utils.repository.ExtendedRepository;

interface UserRepository extends JpaRepository<User,Long>, ExtendedRepository {

	//keeping the name of the procedure inside your repo
	default void executeCallProcedure( )
	{
		callProcedure("raise_notice_check");
	}
 
    
}
