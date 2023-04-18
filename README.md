# API de empréstimos
## Descrição
Projeto de uma API para gerenciar clientes e empréstimos de clientes
## Tecnologias utilizadas
* Java 17
* Maven
* Spring
* Postman
* H2 Database
* Angular 15
* Bootstrap
* Github
## Instalação
Para instalar e executar a API, é necessário:
|         Ferramenta          | Versão |
|:---------------------------:|:------:|
|          IDE Java           |   17   |
|           Angular           |   15   |
###
* Clone o repositório localmente e execute o backend na IDE;
* Instale o node na pasta do frontend: `npm install`;
* Na pasta do frontend, execute o comando `ng serve`;
* No navegador, acesse localhost:4200.
## Endpoints
| Método |         Endpoint         |               Descrição                |
|:------:|:----------------------------------------------------:|:--------------------------------------------------------------------:|
|  GET   | "/api/v1/emprestimo/clientes"                        | Retorna todos os clientes cadastrados                                |
|  GET   | "/api/v1/emprestimo/clientes/{cpf}"                  | Retorna o cliente com o cpf informado                                |
|  POST  | "/api/v1/emprestimo/clientes"                        | Cadastra um novo cliente                                             |
|  PUT   | "/api/v1/emprestimo/clientes/{cpf}"                  | Altera o cliente com o cpf informado                                 |
| DELETE | "/api/v1/emprestimo/clientes/{cpf}"                  | Deleta o cliente com o cpf informado                                 |
|  GET   | "/api/v1/emprestimo/clientes/{cpf}/emprestimos       | Retorna todos os empréstimos do cliente com o cpf informado          |
|  GET   | "/api/v1/emprestimo/clientes/{cpf}/emprestimos/{id}" | Retorna o empréstimo do cliente com o cpf informado e o id informado |
|  POST  | "/api/v1/emprestimo/clientes/{cpf}/emprestimos"      | Cadastra um novo empréstimo para o cliente com o cpf informado       |
| DELETE | "/api/v1/emprestimo/clientes/{cpf}/emprestimos/{id}" | Deleta o empréstimo do cliente com o cpf informado e o id informado  |
