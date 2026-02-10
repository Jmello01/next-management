package br.com.next.management.service;

import br.com.next.management.model.Membro;
import br.com.next.management.repository.MembroRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MembroServiceTest {

    @Mock
    private MembroRepository repository;

    @InjectMocks
    private MembroService service;

    @Test
    @DisplayName("Deve salvar um jovem na célula Next com sucesso")
    void deveSalvarMembroComSucesso() {
        // 1. Arrange (Organizar) - Dados de um jovem da sua célula na Barra
        Membro membroParaSalvar = new Membro(null, "Gabriel Lider", "gabriel@next.com", "21969518262");
        Membro membroSalvo = new Membro(1L, "Gabriel Lider", "gabriel@next.com", "21969518262");

        // Definindo o comportamento do dublê: Quando o save for chamado, retorne o membro com ID
        when(repository.save(any(Membro.class))).thenReturn(membroSalvo);

        // 2. Act (Agir)
        Membro resultado = service.salvar(membroParaSalvar);

        // 3. Assert (Verificar)
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Gabriel Lider", resultado.getNome());

        // Verifica se o repositório foi chamado exatamente 1 vez
        verify(repository, times(1)).save(any(Membro.class));
    }
}
