package com.diego.todo.services;

import com.diego.todo.domain.Todo;
import com.diego.todo.repository.TodoRepository;
import com.diego.todo.services.exeptions.ObjectNotFoudExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

//camada lógica de negocio
//classe de servicços responsável por injetar os service onde for preciso
@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public Todo findById(Integer id){
        Optional<Todo> obj = repository.findById(id);
        return obj.orElseThrow(() ->
                new ObjectNotFoudExeption("objeto não encontrado Id: " + id + " tipo: " + Todo.class.getName()));//se o ojjeto não for encotrado retorna nulo
    }

//listar todos abertos
    public List<Todo> findAllOpen() {
        List<Todo> list = repository.findAllOpen();
        return list;
    }

    //listar todos fechados
    public List<Todo> findAllClose() {
        List<Todo> list = repository.findAllClose();
        return list;

    }


    //listar todos
    public List<Todo> findAll() {
        List<Todo> list = repository.findAll();
        return list;

    }

    public Todo create(Todo obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    //delete
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
