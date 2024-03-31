package br.com.fullstack.education.m1s10ex1.exception;

import br.com.fullstack.education.m1s10ex1.dto.Erro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Indica que esta classe atua como um Controlador de Asesoramento Global
// permite centralizar o tratamento de exceções em toda a aplicação
@ControllerAdvice
public class GlobalExceptionAdvice {

     // Método para manipular exceções do tipo Exception
     @ExceptionHandler(Exception.class)
     public ResponseEntity<?> handler(Exception e) {
          Erro erro = Erro.builder()
                  .codigo("500")
                  .mensagem(e.getMessage())
                  .build();
          // Retorna uma resposta HTTP com status 500 (Internal Server Error) e o corpo da mensagem da exceção
          return ResponseEntity.status(500).body(erro);
     }

     // Método para manipular exceções do tipo NotFoundException
     @ExceptionHandler(NotFoundException.class)
     public ResponseEntity<?> handler(NotFoundException e) {
          Erro erro = Erro.builder()
                  .codigo("404")
                  .mensagem(e.getMessage())
                  .build();
          // Retorna uma resposta HTTP com status 404 (Not Found) e o corpo da mensagem da exceção
          return ResponseEntity.status(404).body(erro);
     }

}
