package com.diego.todo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;


@Entity//a classe sera uma entidade persistida na base de dados
public class Todo  implements Serializable  {

    private static  final long serialVersionUID = 1L;

    //atributos encapsulados
    @Id//sera uma chave primaria
    //id gerado pela base de dados automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataParaFinalizar;
    private Boolean finalizar = false;

    //contrutor sem parametros
    public Todo() {
        super();
    }


    //construtor com parametros
    public Todo(Integer id, String titulo, String descricao, Date dataParaFinalizar, Boolean finalizar) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataParaFinalizar = dataParaFinalizar;
        this.finalizar = finalizar;
    }


    //getter e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date  getDataParaFinalizar() {
        return dataParaFinalizar;
    }

    public void setDataParaFinalizar(Date dataParaFinalizar) {
        this.dataParaFinalizar = dataParaFinalizar;
    }

    public Boolean getFinalizar() {
        return finalizar;
    }

    public void setFinalizar(Boolean finalizar) {
        this.finalizar = finalizar;
    }


    //eqauls
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) && Objects.equals(titulo, todo.titulo) && Objects.equals(descricao, todo.descricao) && Objects.equals(dataParaFinalizar, todo.dataParaFinalizar) && Objects.equals(finalizar, todo.finalizar);
    }

    //hashcode
    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descricao, dataParaFinalizar, finalizar);
    }
}
