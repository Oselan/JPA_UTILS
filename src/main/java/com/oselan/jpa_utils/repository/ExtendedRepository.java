package com.oselan.jpa_utils.repository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ExtendedRepository  { 
  
    /***
     * Generic call procedure method that logs any RAISE NOTICE 
     * @param procedureName
     * @param params
     */
    void callProcedure(String procedureName, Object... params);
 
}
