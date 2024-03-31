package br.com.fullstack.education.m1s10ex1.service;

import java.util.List;

// Interface Genérica
// Para deixar a tipagem variável costuma-se colocar a letra "T"
public interface GenericService<T> {

    //CREATE
    T criar(T entity);

    //READ
    List<T> buscarTodos();

    T buscarPorId(Long id);

    //UPDATE
    T alterar(Long id, T entity);


    //DELETE
    void excluir(Long id);

}
