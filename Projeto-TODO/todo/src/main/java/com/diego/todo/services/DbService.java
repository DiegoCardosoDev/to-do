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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		

		Todo t1 = new Todo(null, "estudar spring boot", "estudar spring boot", sdf.parse("20/11/2021"),	true);
		Todo t2 = new Todo(null, "estudar java", "estudar java", sdf.parse("20/11/2021"),true);
		Todo t3 = new Todo(null, "estudar", "estudar mysql", sdf.parse("20/11/2021"),false);
		Todo t4 = new Todo(null, "estudar", "estudar angular", sdf.parse("20/11/2021"),true);
		Todo t5 = new Todo(null, "iniciar projetos", "estudar angular", sdf.parse("29/12/2021"),true);




		todoRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5));
	}

}
