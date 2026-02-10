#  Next Management System - Célula Novos Começos

Sistema Full-Stack desenvolvido para a gestão de membros da célula **Next**, da Igreja Novos Começos (Barra da Tijuca, RJ). Este projeto foi criado como parte dos meus estudos em Ciência da Computação para aplicar conceitos de APIs RESTful, persistência de dados e interfaces reativas.

## 🛠 Tecnologias Utilizadas

### Back-end (Java)
- **Java 21**: Versão mais recente para aproveitar as melhorias de performance.
- **Spring Boot 3**: Framework para criação da API.
- **Spring Data JPA**: Para abstração da camada de persistência.
- **H2 Database**: Banco de dados em memória para desenvolvimento ágil.

### Front-end (Web)
- **Angular 19**: Framework moderno para uma SPA (Single Page Application) rápida.
- **TypeScript**: Para garantir tipagem e evitar erros em tempo de execução.
- **SCSS**: Estilização modular e moderna.

##  Funcionalidades
- **CRUD Completo**: Cadastro, Listagem, Edição e Exclusão de membros.
- **Busca Reativa**: Filtro de membros em tempo real por nome ou e-mail.
- **Feedback Visual (Toast)**: Notificações de sucesso ou erro para o usuário.
- **Persistência em Arquivo**: Os dados não se perdem ao reiniciar o servidor Java.

## 🏗 Como Executar o Projeto

### 1. Pré-requisitos
- JDK 21 instalado.
- Node.js e Angular CLI instalados.

### 2. Rodando o Back-end
```bash
  cd management
 ./mvnw spring-boot:run
````
O servidor iniciará em: http://localhost:8080

### 3. Rodando o Front-end
```bash
  cd frontend
  ng serve
```
Acesse em: http://localhost:4200

Desenvolvido por João Ricardo - Estudante de Ciência da Computação.