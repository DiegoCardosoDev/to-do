import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from 'src/app/models/todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  //instacia do objeto todo
  todo: Todo  = {
    titulo: '',
    descricao: '',
    dataParaFinalizar: new Date(),
    finalizar: false
  }


  //construtor
  constructor(private router: Router, private service: TodoService) { }

  ngOnInit(): void {

  }

  //metodo create
  create():void{
    this.formataData();
    this.service.create(this.todo).subscribe((resposta) =>{
      this.service.message('To-do criado!')
      this.router.navigate(['']);
    }, err =>{
      this.service.message('falha ao criar to-do!')
      this.router.navigate(['']);
    })
  }

  //implementação do botao cancelar,volta para home
  cancel():void{
    this.router.navigate(['']);

  }


  //metodo pra formatar a data como o back exige
  formataData():void{
    let data = new Date(this.todo.dataParaFinalizar)
    this.todo.dataParaFinalizar = `${data.getDate()}/${data.getMonth() + 1}/${data.getFullYear()}`
  }

}
