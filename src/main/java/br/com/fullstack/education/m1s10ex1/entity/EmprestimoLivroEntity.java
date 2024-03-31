package br.com.fullstack.education.m1s10ex1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "emprestimos")
public class EmprestimoLivroEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // aqui olhamos de EmprestimoLivro para Emprestimo e fica ManyToOne porque olhando
    // de Emprestimo para EmprestimoLivro a relação é OneToMany
    @ManyToOne
    // Sempre é utilizado quando se trata de entidade para entidade
    // se deixa explícito o nome do campo na tabela
    @JoinColumn(name = "emprestimo_id", nullable = false)
    private EmprestimoEntity emprestimo;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private LivroEntity livro;


}
