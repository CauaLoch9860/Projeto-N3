# Climate App

Projeto para gerenciamento de dados climáticos, cidades e usuários, com integração à API WeatherStack para consulta de informações meteorológicas.

## **Tecnologias Utilizadas**
- Java 17
- Spring Boot
- H2 Database (banco de dados em memória)
- API WeatherStack
- Docker
- Postman

---

## **Como Executar o Projeto**

### **Pré-requisitos**
- Java 17+
- Docker e Docker Compose
- Maven

### **Passos para executar**
1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd climate-app

2. Compile o projeto:
   ```bash
   mvn clean package

3. Execute o docker:
   ```bash
   docker-compose up

## **Rotas da API**

### **Usuários**
1. Listar todos os usuários:
   - Método: GET
   - URL: /users
   - Exemplo de Resposta (200):
     - { "id": 1, "username": "admin", "password": "123456","role": "admin" }
   - Possíveis Erros: 
     - 500 Internal Server Error: Problema ao acessar o banco de dados.


2. Criar um novo usuário

   - Método: POST
   - URL: /users
   - Exemplo de Requisição:
     - {"username": "newUser","password": "newPassword","role": "user"}
   - Exemplo de Resposta (200): 
     - {"id": 2, "username": "newUser", "password": "newPassword","role": "user"}
   - Possíveis Erros:
     - 400 Bad Request: Dados inválidos na requisição.
     

3. Deletar um usuário:
   - Método: DELETE
   - URL: /users/{id}
   - Exemplo de Requisição:
     - /users/1
   - Resposta (204): Sem conteúdo.
   - Possíveis Erros:
     - 404 Not Found: Usuário não encontrado.

### **Cidades**
1. Listar todas os cidades:
    - Método: GET
    - URL: /cities
    - Exemplo de Resposta (200):
        - [{"id": 6,"name": "Rio de Janeiro","country": "Brasil","climateData": "Ensolarado"}]

2. Criar uma nova cidade:

    - Método: POST
    - URL: /cities
    - Exemplo de Requisição:
        - {"name": "Rio de Janeiro","country": "Brasil","climateDate": "teste" }
    - Exemplo de Resposta (200):
        - {"id":2,  "name": "Rio de Janeiro","country": "Brasil","climaDate": "ensolarado"}

3. Deletar uma cidade:
    - Método: DELETE
    - URL: /cities/{id}
    - Exemplo de Requisição:
        - /cities/1
    - Resposta (204): Sem conteúdo.
    - Possíveis Erros:
        - 404 Not Found: Cidade não encontrada.

### **Clima**
1. Listar todos os dados climáticos:

   - Método: GET
   - URL: /climate-data
   - Exemplo de reposta:
      - [{"id": 1,"date": "2024-12-02","temperature": 28.0,"humidity": 50.0,"weatherDescription": "Ensolarado","city": {"id": 1,"name": "São Paulo","country": "Brasil"} }]


2. Criar um novo dado climático:

   - Método: POST
   - URL: /climate-data
   - Exemplo de Requisição: 
     - {"cityId": 1,"date": "2024-12-02","temperature": 28.0,"humidity": 50.0,"weatherDescription": "Ensolarado"}
   - Exemplo de Resposta (200):
     - {"id": 1,"date": "2024-12-02","temperature": 28.0,"humidity": 50.0,"weatherDescription": "Ensolarado","city": {"id": 1,"name": "São Paulo","country": "Brasil"} }


3. Deletar um dado climático:

   - Método: DELETE
   - URL: /climate-data/{id}
   - Exemplo de Requisição:
     - /climate-data/1
   - Resposta (204): Sem conteúdo.
   - Possíveis Erros:
     - 404 Not Found: Dado climático não encontrado.

### **Obter clima de uma cidade específica** ###

   - Método: GET
   - URL: /climate-data/weather/{city}
   - Descrição: Retorna as informações climáticas de uma cidade, utilizando uma API externa.
   - Exemplo de Requisição:
     - GET http://localhost:8080/climate-data/weather/CityName
   - Exemplo de Resposta:
     - {"temperature": 23.5,"humidity": 75, "weatherDescription": "Sunny"}

   - Erros Esperados:
     - 404 Not Found: Se a cidade não for encontrada na API externa.
     - 400 Bad Request: Se o nome da cidade não for válido.

### **Banco de dados** ###

   - O banco de dados é uma implementação simples utilizando o H2 Database para desenvolvimento. O H2 pode ser acessado via http://localhost:8080/h2-console.
   ```bash
   URL: http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:climate-db
   Username: sa
   Password: password