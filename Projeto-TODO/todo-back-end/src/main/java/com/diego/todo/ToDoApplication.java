package com.diego.todo;


import com.diego.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class ToDoApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository todoRepository;



  //classe responsável por subir a aplicação
	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);



	}

	@Override
	public void run(String... args) throws Exception {



	}

}
