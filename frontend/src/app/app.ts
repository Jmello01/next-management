import { FormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MembroService } from './services/membro.service';
import { Membro } from './models/membro.model';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class AppComponent implements OnInit {
  // 1. Definição de Variáveis (Atributos)
  membros: Membro[] = []; // Estava faltando essa linha no seu código!
  novoMembro: Membro = { nome: '', email: '', celular: '' };

  constructor(private membroService: MembroService) {}

  ngOnInit(): void {
    this.carregarMembros();
  }

  // 2. Método de Listagem
  carregarMembros(): void {
    this.membroService.listarTodos().subscribe({
      next: (dados: Membro[]) => {
        this.membros = dados;
        console.log('Membros carregados:', dados);
      },
      error: (err: any) => {
        console.error('Erro ao conectar com o Java:', err);
      }
    }); // <--- Fecha o subscribe aqui
  } // <--- Fecha o método carregarMembros aqui

  // 3. Método de Cadastro (Independente!)
  cadastrar(): void {
    this.membroService.salvar(this.novoMembro).subscribe({
      next: (membroSalvo) => {
        console.log('Salvo com sucesso!', membroSalvo);
        this.carregarMembros(); // Atualiza a lista na hora
        this.novoMembro = { nome: '', email: '', celular: '' }; // Limpa os campos
      },
      error: (err: any) => {
        console.error('Erro ao salvar:', err);
      }
    });
  }
}
