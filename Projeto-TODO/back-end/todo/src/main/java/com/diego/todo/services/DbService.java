package com.diego.todo.services;

import com.diego.todo.domain.Todo;
import com.diego.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DbService {

    //responsável por gerenciar a instacia
    @Autowired
    private TodoRepository todoRepository;


    //metodo responsável por instacia a base de dados
    @Bean
    public void instanciaBaseDeDados() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Todo t1 = new Todo(null,"estudar Docker","aprender js", sdf.parse("01/05/2022 "),false);
        Todo t2 = new Todo(null,"estudar Docker","aprender Docker", sdf.parse("01/05/2022 "),false);
        Todo t3 = new Todo(null,"estudar Docker","aprender html", sdf.parse("01/05/2022"),false);
        todoRepository.saveAll(Arrays.asList(t1,t2,t3));

    }
}
