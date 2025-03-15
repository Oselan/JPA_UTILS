CREATE SCHEMA IF NOT EXISTS "jpa_utils" ;
 
--- DUMMY PROCEDURE FOR TESTING
CREATE OR REPLACE PROCEDURE "jpa_utils".raise_notice_check()
 LANGUAGE plpgsql
AS $procedure$
BEGIN 

    
    
    RAISE LOG  'Log from procedure...'; 
    RAISE DEBUG  'DEBUG from procedure..';
     
    RAISE INFO  'INFO from procedure...'; 
    RAISE WARNING  'WARNING  from procedure...';
    RAISE NOTICE 'Notice from procedure ...';
    
 --   RAISE EXCEPTION  'EXCEPTION  from procedure...'; 
    
END;
$procedure$
$$ 