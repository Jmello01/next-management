package br.com.next.management.service;

import br.com.next.management.model.Membro;
import br.com.next.management.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MembroService {

    @Autowired // Injeção de Dependência: O Spring entrega o repositorio pronto
    private MembroRepository repository;

    public List<Membro> listarTodos() {
        return repository.findAll();
    }

    public Membro salvar(Membro membro) {
        // Aqui voce poderia colocar validacoes (ex: checar se o e-mail ja existe)
        return repository.save(membro);
    }

    public Optional<Membro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}