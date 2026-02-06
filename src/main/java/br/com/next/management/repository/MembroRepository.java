package br.com.next.management.repository;

import br.com.next.management.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {
    // Aqui nao precisamos escrever codigo.
    // O JpaRepository ja nos da metodos como save(), delete(), e findAll() prontos.
}