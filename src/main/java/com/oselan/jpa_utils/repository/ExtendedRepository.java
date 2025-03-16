package com.oselan.jpa_utils.repository;

public interface ExtendedRepository  { 
  
    /***
     * Generic call procedure method that logs any RAISE NOTICE 
     * @param procedureName
     * @param params
     */
    void callProcedure(String procedureName, Object... params);
 
}
