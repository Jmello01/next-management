import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
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
  membros: Membro[] = [];
  novoMembro: Membro = { nome: '', email: '', celular: '' };
  isEditando = false;
  membrosFiltrados: Membro[] = [];
  termoBusca: string = '';
  constructor(private membroService: MembroService) {}

  ngOnInit(): void {
    this.carregarMembros();
  }

  carregarMembros(): void {
    this.membroService.listarTodos().subscribe({
      next: (dados: Membro[]) => {
        this.membros = dados;
        this.membrosFiltrados = dados; // No início, a lista filtrada é igual à original
      }
    });
  }

  mensagemToast: string = '';
  tipoToast: 'sucesso' | 'erro' = 'sucesso';

  exibirToast(msg: string, tipo: 'sucesso' | 'erro' = 'sucesso') {
    this.mensagemToast = msg;
    this.tipoToast = tipo;

    // Limpa a mensagem após 3 segundos
    setTimeout(() => {
      this.mensagemToast = '';
    }, 3000);
  }

  // Agora, atualize seus métodos de sucesso
  salvarMembro(): void {
    if (this.isEditando && this.novoMembro.id) {
      this.membroService.atualizar(this.novoMembro.id, this.novoMembro).subscribe({
        next: () => {
          this.exibirToast('✅ Membro atualizado com sucesso!');
          this.finalizarAcao();
        }
      });
    } else {
      this.membroService.salvar(this.novoMembro).subscribe({
        next: () => {
          this.exibirToast('🚀 Novo jovem cadastrado no Next!');
          this.finalizarAcao();
        }
      });
    }
  }

  excluir(id: number): void {
    if (confirm('Deseja mesmo remover este membro?')) {
      this.membroService.deletar(id).subscribe({
        next: () => {
          this.exibirToast('🗑️ Membro removido!', 'erro');
          this.carregarMembros();
        }
      });
    }
  }

  prepararEdicao(membro: Membro): void {
    this.novoMembro = { ...membro }; // Cópia para não alterar a lista enquanto digita
    this.isEditando = true;
  }

  finalizarAcao(): void {
    this.novoMembro = { nome: '', email: '', celular: '' };
    this.isEditando = false;
    this.carregarMembros();
  }

filtrarMembros(): void {
  const termo = this.termoBusca.toLowerCase(); // Padroniza para minúsculo

  this.membrosFiltrados = this.membros.filter(membro =>
    membro.nome.toLowerCase().includes(termo) ||
    membro.email.toLowerCase().includes(termo)
  );
}
}
