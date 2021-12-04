package com.diego.todo.repository;

import com.diego.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository  extends JpaRepository<Todo, Integer> {

    //essa query seleciona os todos em aberto
    @Query("SELECT  obj FROM Todo  obj WHERE obj.finalizar =   false ORDER BY obj.dataParaFinalizar")
    List<Todo> findAllOpen();


    //essa query seleciona os todos fechados
    @Query("SELECT  obj FROM Todo  obj WHERE obj.finalizar =   true ORDER BY obj.dataParaFinalizar")
    List<Todo> findAllClose();

}
