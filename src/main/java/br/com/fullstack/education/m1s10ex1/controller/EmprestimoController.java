package br.com.fullstack.education.m1s10ex1.controller;

import br.com.fullstack.education.m1s10ex1.entity.EmprestimoEntity;
import br.com.fullstack.education.m1s10ex1.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    private final EmprestimoService service;


    @GetMapping
    public ResponseEntity<List<EmprestimoEntity>> get() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<EmprestimoEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    /*Sempre retornar Status HTTP 201 em métodos POST */
    @PostMapping
    public ResponseEntity<EmprestimoEntity> post(@RequestBody EmprestimoEntity emprestimo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(emprestimo));
    }

    @PutMapping("{id}")
    public ResponseEntity<EmprestimoEntity> put(@PathVariable Long id, @RequestBody EmprestimoEntity emprestimo) {
        return ResponseEntity.status(HttpStatus.OK).body(service.alterar(id, emprestimo));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
