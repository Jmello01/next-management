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
        // Validação de Negócio: Regra da Célula Next
        if (membro.getNome() == null || membro.getNome().trim().isEmpty()) {
            throw new RuntimeException("O nome do membro é obrigatório!");
        }
        // Só chega aqui se tiver nome
        return repository.save(membro);
    }

    public Optional<Membro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Membro atualizar(Long id, Membro dadosNovos) {
        // 1. Verificamos se o jovem realmente existe no banco da célula
        if (repository.existsById(id)) {
            // 2. Garantimos que o ID do objeto seja o mesmo da URL
            dadosNovos.setId(id);
            // 3. O save() aqui vai atuar como um UPDATE
            return repository.save(dadosNovos);
        }
        return null; // Se não existir, retornamos null para o Controller dar 404
    }
}