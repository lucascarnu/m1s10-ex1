package br.com.fullstack.education.m1s10ex1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "emprestimos")
public class EmprestimoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Muitos emprestimos podem estar relacionados com um leitor
    // Um Leitor pode estar relacionado a muitos empréstimos.
    @ManyToOne
    // Sempre é utilizado quando se trata de entidade para entidade
    @JoinColumn(name = "leitor_id", nullable = false)
    private LeitorEntity leitor;
    // nullable = false, tradução: nulo permitido? = falso. (Obriga a ter valor)
    @Column(nullable = false)
    private LocalDate dataEmprestimo = LocalDate.now();

    private LocalDate dataDevolucao;

    // Emprestimo precisa ver os itens emprestados.
    // Um Emprestimo(One) está relacionado com um ou muitos(Many) itens (livrosEmprestados)
    // Para trazer todos os items relacionados com GetMapping, usar EAGER ao invés de LAZY
    // *** O OneToMany SEMPRE vai ter uma relação com uma LISTA ***
    // ALL: Se deletar um emprestimo, também serão deletados todos os livros listados nesse emprestimo
    // mappedBy: indica o nome do campo (atributo) na classe relacionada (EmprestimoLivroEntity)
    // Neste caso a relaçao é com o campo "emprestimo"
    @OneToMany(mappedBy = "emprestimo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EmprestimoLivroEntity> livrosEmprestados;
}
