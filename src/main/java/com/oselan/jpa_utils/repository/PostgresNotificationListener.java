package com.oselan.jpa_utils.repository;

import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.postgresql.PGConnection;
import org.postgresql.PGNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostgresNotificationListener   {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${spring.jpa.properties.hibernate.default_schema:public}") // Default schema if not set
	private String defaultSchema;

	private final ExecutorService executorService = Executors.newSingleThreadExecutor();
 
    @Async
    public void listenForNotifications() {
        executorService.submit(() -> {
            try (Connection con = jdbcTemplate.getDataSource().getConnection()) {
                PGConnection pgCon = con.unwrap(PGConnection.class);
                try (Statement stmt = con.createStatement()) {
                    stmt.execute("LISTEN log_channel");
                    log.info("Listening to PostgreSQL notifications on 'log_channel'...");
                    while (!Thread.currentThread().isInterrupted()) {
                        PGNotification[] notifications = pgCon.getNotifications(5000);
                        if (notifications != null) {
                            for (PGNotification notification : notifications) {
                                log.info("Received PostgreSQL Notification: {}", notification.getParameter());
                            }
                        }
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e) {
                log.error("Error listening for PostgreSQL notifications", e);
            }
        });
    }
 
}
