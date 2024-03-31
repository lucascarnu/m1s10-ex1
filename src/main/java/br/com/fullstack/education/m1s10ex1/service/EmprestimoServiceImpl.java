package br.com.fullstack.education.m1s10ex1.service;

import br.com.fullstack.education.m1s10ex1.entity.EmprestimoEntity;
import br.com.fullstack.education.m1s10ex1.exception.NotFoundException;
import br.com.fullstack.education.m1s10ex1.repository.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    private final EmprestimoRepository repository;

    @Override
    public EmprestimoEntity criar(EmprestimoEntity entity) {
        // Geralmente não se usa. Aqui, sim, porque está se usando a entidade como dto
        entity.setId(null);
        return repository.save(entity);
    }

    @Override
    public List<EmprestimoEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    //O método orElseThrow pertence à classe Optional. Frequentemente uado para evitar o tratamento de
    //valores nulos de forma direta.
    //Método lambda dentro do orElseThrow: () -> {/* Corpo da expressão lambda */}
    //As chaves {} são usadas sé tiver mais de uma instrução. Como tem uma só, então não precisa.
    public EmprestimoEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Empréstimo não encontrado com id " + id));
    }

    @Override
    public EmprestimoEntity alterar(Long id, EmprestimoEntity entity) {
        buscarPorId(id);
        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}