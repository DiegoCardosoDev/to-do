import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from 'src/app/models/todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-finalizados',
  templateUrl: './finalizados.component.html',
  styleUrls: ['./finalizados.component.css']
})
export class FinalizadosComponent implements OnInit {

  listFineshed: Todo[] = [];


  constructor(private service: TodoService, private router: Router) { }

  ngOnInit(): void {
    this.findAll();
  }


  //esse metodo vai carregar apenas todos a serem finalizados,no bagde mostra quantos estao finalizados
  findAll(): void{
    this.service.findAll().subscribe((resposta) => {
      resposta.forEach(todo => {

        if(todo.finalizar){
          this.listFineshed.push( todo);
        }
      })
    })
  }

  voltar(): void{
    this.router.navigate(['']);
  }

 

}
