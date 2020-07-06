package com.sim.app;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SimCardManagementAppApplication {

	@Autowired
	private DataSource datasource;

	public static void main(String[] args) {
		SpringApplication.run(SimCardManagementAppApplication.class, args);
	}

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("ticketCache");
	}
}
