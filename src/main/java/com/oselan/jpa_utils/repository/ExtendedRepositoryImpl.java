package com.oselan.jpa_utils.repository;
 
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLWarning;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ExtendedRepositoryImpl implements ExtendedRepository  {

  
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${spring.jpa.properties.hibernate.default_schema:public}") // Default schema if not set
    private String defaultSchema;

    @Override
    public void callProcedure(String procedureName, Object... params) {
        String paramPlaceholders = IntStream.range(0, params.length)
                .mapToObj(i -> "?")
                .collect(Collectors.joining(", "));

        String procedureCall = String.format("CALL %s.%s(%s)", defaultSchema, procedureName, paramPlaceholders);

        jdbcTemplate.execute((Connection con) -> {
            try (CallableStatement stmt = con.prepareCall(procedureCall)) {
                // Bind parameters dynamically
                for (int i = 0; i < params.length; i++) {
                    stmt.setObject(i + 1, params[i]);
                }

                stmt.execute();

                // Capture PostgreSQL RAISE NOTICE messages
                SQLWarning warning = stmt.getWarnings();
                while (warning != null) {
                    log.info("PostgreSQL NOTICE On ({}): {}" ,procedureName, warning.getMessage());
                    warning = warning.getNextWarning();
                }
            }
            return null;
        });
    }
}
