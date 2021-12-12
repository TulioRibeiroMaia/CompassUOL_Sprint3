# CompassUOL_Sprint3


Avaliação Sprint3 Progama de bolsas CompassUOL

Foi criada uma API REST para listar, cadastrar, atualizar e deletar os Estados do Brasil.

#Endpoints:

## GET ("/api/states") 
- Lista todos os Estados presentes no banco de dados, podendo ser feita o filtro por região. Ex.: "localhost:8080/api/states?regiao=Nordeste";

## POST ("/api/states") 

Cadastra Estados na API. Ex.: "localhost:8080/api/states/".

Exemplo de informações que precisam ser passadas para cadastrar um novo estado.:
- {
- "id": 999,
- "name": "Novo Estado",
- "region": "Norte",
- "population": 999999,
- "capital": "Nova Capital",
- "area": 999999.99
- },

>[!NOTE]
>
>As regiões permitidas e pré-definidas para cadastro são:

- Norte;
- Nordeste;
- Centro_Oeste;
- Sul;
- Sudeste.

## GET ("/api/states/{id}")

Lista os Estados conforme o ID que o usuário indicar na URL. Ex.: "http://localhost:8080/api/states/1".

## PUT("/api/states/{id}") 

Atualiza os dados dos Estados conforme o ID que o usuário indicar na URL. Ex: "http://localhost:8080/api/states/15".

>[!NOTE]
>
>O usuário precisa informar os campos abaixo para que a requisição de atualização seja concluída:

- {
- "name": "Novo Estado",
- "region": "Norte",
- "population": 999999,
- "capital": "Nova Capital",
- "area": 999999.99
- },

## DELETE("/api/states/{id}") 

Deleta os Estados conforme o ID que o usuário indicar na URL. Ex: "http://localhost:8080/api/states/13".
