package com.diego.todo.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.diego.todo.services.DbService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DbService service;

	@Bean
     public boolean instacia() throws ParseException {
    	 this.service.instaciabaseDeDados();
    	 return true;
     }

}
