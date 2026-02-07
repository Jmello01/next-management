import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Membro } from '../models/membro.model';

@Injectable({
  providedIn: 'root' // Isso diz que o Service é um Singleton (uma única instância para o app todo)
})
export class MembroService {

  // A URL da sua API Java que configuramos no Spring Boot
  private apiUrl = 'http://localhost:8080/api/membros';

  constructor(private http: HttpClient) { }

  // Método que retorna um "Observable" (um fluxo de dados que o Angular vai 'observar')
   listarTodos(): Observable<Membro[]> {
    return this.http.get<Membro[]>(this.apiUrl);
  }

  // Adicione este método dentro da classe MembroService
  salvar(membro: Membro): Observable<Membro> {
   return this.http.post<Membro>(this.apiUrl, membro);
 }

  deletar(id: number): Observable<void> {
   return this.http.delete<void>(`${this.apiUrl}/${id}`);
}

}
