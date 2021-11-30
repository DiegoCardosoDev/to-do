package com.diego.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
