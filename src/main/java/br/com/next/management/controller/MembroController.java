package br.com.next.management.controller;

import br.com.next.management.model.Membro;
import br.com.next.management.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/membros")
public class MembroController {

    @Autowired
    private MembroService service;

    // Retorna a lista de todos os jovens cadastrados
    @GetMapping
    public List<Membro> listar() {
        return service.listarTodos();
    }

    // Recebe um JSON do Postman e salva como um novo Membro
    @PostMapping
    public Membro cadastrar(@RequestBody Membro membro) {
        return service.salvar(membro);
    }

    // Busca um membro especifico pelo ID passado na URL
    @GetMapping("/{id}")
    public ResponseEntity<Membro> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok) // Se achar, retorna 200 OK
                .orElse(ResponseEntity.notFound().build()); // Se nao, retorna 404
    }
}