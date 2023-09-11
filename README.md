## Udemy Desenvolvimento Web com Quarkus

![Quarkus-Logo](/imgs/Img-0-Quarkus-Logo.jpg)

Projeto do curso "Desenvolvimento Web com Quarkus - Básico" da Udemy: CRUD de Produtos.

| Tecnologia | Versão      |
|------------|-------------|
| Gradle     | 8.1.1       |
| Java       | 17.0.6      |
| Quarkus    | 3.2.5.Final |


## Passos
1. Criar o projeto no IntelliJ:
- Language: Java
- Group: com.crud
- Artifact: produtos
- JDK: 17 (ou outra)
- Quarkus: 3.2.5.Final (versão estável)
- Extensions:
  * RESTEasy Classic
  * RESTEasy Classic JSON-B
  * SmallRye OpenAPI
  * SmallRye Health
  * Hibernate ORM
  * Hibernate ORM with Panache
  * JDBC Driver - H2

![Starter-Project](/imgs/Img-1-Starter.jpg)

2. Buildar o projeto:

![Build-Project](/imgs/Img-2-Build.jpg)

3. Executar o projeto, sem modificá-lo ainda, e verificar a url principal e a de exemplo:
- http://localhost:8080/

![Run-Project](/imgs/Img-4-Run.jpg)

- http://localhost:8080/produtos/hello

![Run-Hello](/imgs/Img-5-Hello.jpg)

4. Criar a classe Produto em `src/main/java/com.crud/`:
- herda de PanacheEntity;
- é anotada com `@Entity`;
- possui atributos id (criado automaticamente), nome, valor, dataCriacao, dataAtualizacao;
- dataCriacao é anotado com `@CreationTimestamp`;
- dataAtualizacao é anotado com `@UpdateTimestamp`;
- possui um contrutor vazio e um com todos os atributos;
- possui getters e setters.

5. Criar a classe ProdutoResource em `src/main/java/com.crud/`:
- possui a rota de `"/produtos"`;
- consome e produz `MediaType.APPLICATION_JSON`;
- implementa as 4 funções básicas do CRUD;
- as funções CRUD que não implementam o verbo GET devem ser anotadas com `@Transactional`.

6. Configurar o arquivo `application.properties`.

7. Executar a aplicação e testar todas as funções do CRUD de Produtos com o Swagger em http://localhost:8080/q/swagger-ui/.

![Run-Swagger](/imgs/Img-6-Swagger.jpg)

8. Verificar outras informações da aplicação em http://localhost:8080/q/dev-v1/ e http://localhost:8080/q/health-ui/ . 


## Referências
Udemy Desenvolvimento Web com Quarkus - Básico - por Vinicius Ferraz Campos Florentino: 
https://www.udemy.com/course/des-web-quarkus-basico/

Github - Vinicius Ferraz Campos Florentino:
https://github.com/viniciusfcf/udemy-quarkus-basico/tree/master/meu-primeiro-crud