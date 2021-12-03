package com.diego.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.todo.domain.Todo;
import com.diego.todo.repositories.TodoRepository;
import com.diego.todo.services.exeptions.ObjectNotFoundExeption;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;
	
	public Todo findById(Integer id ) {
		Optional<Todo> obj  = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption(
				"Objeto Não encontrado " + id + " Tipo: " + Todo.class.getName() ));
		
	}

	public List<Todo> findAllOpen() {
		List<Todo> list = repository.findAllOpen();
		return list;
	}

	public List<Todo> findAllClose() {
		List<Todo> list = repository.findAllClose();
		return list;
		
	}

	public List<Todo> findAll() {
		List<Todo> list = repository.findAll();
		return list;
	
	}

	public Todo create(Todo obj) {
	
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	public Todo update(Integer id, Todo obj) {
		Todo newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizar(obj.getFinalizar());
		return repository.save(newObj); 
		
	
	}

}
