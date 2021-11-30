import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/models/todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit {
  //todos finalizados
  closed = 0;

  list: Todo[] = [];
  listFineshed: Todo[] = [];


  constructor(private service: TodoService) { }

  ngOnInit(): void {
    this.findAll();
  }


  //esse metodo vai carregar apenas todos a serem finalizados,no bagde mostra quantos estao finalizados
  findAll(): void{
    this.service.findAll().subscribe((resposta) => {
      resposta.forEach(todo => {

        if(todo.finalizar){
          this.listFineshed.push( todo);
        }else{
          this.list.push(todo);
        }
      })
      this.closed = this.listFineshed.length

    })
  }
 

}
