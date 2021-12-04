package com.diego.todo.resources;


import com.diego.todo.domain.Todo;
import com.diego.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


//essa classe recebe as requisiçoes Http
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/todos")//endpoint inicial http://localhost:8080/todos
public class TodoResource {

    @Autowired
    private TodoService service;

    @GetMapping(value = "/{id}")//retorna um requisição tipo GET
    public ResponseEntity<Todo> findById(@PathVariable Integer id){
        Todo obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    //metodo para listar Todos abertos
    @GetMapping(value = "/open")
    public ResponseEntity<List<Todo>> listOpen(){
        List<Todo> list = service.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/close")
    public ResponseEntity<List<Todo>> listClose(){
        List<Todo> list = service.findAllClose();
        return ResponseEntity.ok().body(list);
    }

    //listar todos todos
    @GetMapping
    public ResponseEntity<List<Todo>> listAll(){
        List<Todo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //metodo patra criar todos
    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo obj){
     obj= service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
//deletar um todo
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj){
        Todo newObj = service.update(id,obj);
        return  ResponseEntity.ok().body(newObj);

    }


}
