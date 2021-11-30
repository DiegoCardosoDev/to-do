package com.diego.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.diego.todo.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {


	@Query("SELECT obj FROM  Todo obj WHERE obj.finalizar = false ORDER BY  obj.dataParaFinalizar ")
	List<Todo> findAllOpen();

	@Query("SELECT obj FROM  Todo obj WHERE obj.finalizar = true ORDER BY  obj.dataParaFinalizar ")

	List<Todo> findAllClose();

}
