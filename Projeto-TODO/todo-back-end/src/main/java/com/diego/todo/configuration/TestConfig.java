package com.diego.todo.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.diego.todo.services.DbService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DbService dbService;

	public boolean instacia() throws Exception{
		this.dbService.instaciabaseDeDados();
		return true;
	}

}
