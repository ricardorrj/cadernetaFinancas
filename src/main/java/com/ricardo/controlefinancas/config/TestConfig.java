package com.ricardo.controlefinancas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ricardo.controlefinancas.service.DBServices;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBServices service;
	
	@Bean
	public void instanciaDb() {
		this.service.instanciaDb();
	}
	
}
