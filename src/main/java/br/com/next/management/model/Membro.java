package br.com.next.management.model;

import jakarta.persistence.*; // Padrao Jakarta para persistencia (Spring 3+)
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok: Cria getters e setters em tempo de compilacao
@AllArgsConstructor // Cria construtor com todos os campos
@NoArgsConstructor // Cria construtor vazio (obrigatorio para o Hibernate)
@Entity // Diz que esta classe e uma tabela no banco de dados
@Table(name = "membros")
public class Membro {

    @Id // Define o ID como Chave Primaria (Busca rapida O(1))
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o ID (1, 2, 3...)
    private Long id;

    private String nome;
    private String email;
    private String celular;
}