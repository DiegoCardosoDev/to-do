package com.diego.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.todo.domain.Todo;
import com.diego.todo.repositories.TodoRepository;

@Service
public class DbService {

	@Autowired
	private TodoRepository todoRepository;

	public void instaciabaseDeDados() throws ParseException {

		//padrao de data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		//instacia dos objetos to-dos
		Todo t1 = new Todo(null, "estudar ", "estudar spring boot", sdf.parse("20/11/2021"),	true);


		todoRepository.saveAll(Arrays.asList(t1));
	}

}
