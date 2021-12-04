package com.diego.todo.cofiguration;


import com.diego.todo.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")//quamdp esse perfil esta ativo sera instaciado a base de dados
public class TestConfig {


    @Autowired
    private DbService service;

    public boolean instancia() throws ParseException {
        this.service.instanciaBaseDeDados();
        return true;
    }


}
