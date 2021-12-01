import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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


  constructor(private service: TodoService,private router: Router) { }

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

  //metodo finalizar tarefa
  finalizar(item: Todo):void{
    item.finalizar = true;
    this.service.update(item).subscribe(() => {
        this.service.message('Task Finalizada com sucesso!');
        this.list = this.list.filter(todo => todo.id !== item.id);
        this.closed++;

    });
    
  }

  //metodo deletar
  delete(id: any):void{
    this.service.delete(id).subscribe((resposta) => {

      if(resposta === null){
        this.service.message('Task deletada com sucesso!');//mensagem se deletar

        this.list = this.list.filter(todo => todo.id !== id);
      }
    })
  }

  navegarParaFinalizar(): void{
    this.router.navigate(['finalizar'])

  }

 
 

}
