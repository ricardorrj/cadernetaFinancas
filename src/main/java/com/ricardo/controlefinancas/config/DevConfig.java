package com.ricardo.controlefinancas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ricardo.controlefinancas.service.DBServices;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBServices service;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaDb() {
		if(strategy.equals("create")) {
			this.service.instanciaDb();
		}
		return false;
	}
}
