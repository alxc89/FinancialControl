<h1 style="text-align: center; font-weight: bold;">Controle Financeiro</h1>

## Sobre o Projeto

O projeto é uma api voltada para o cadastro de despesas e receitas, a fim de controlar as finanças pessoais. É um projeto desenvolvido de forma simples, visando o simples, que registrar Entradas e saídas de receitas. Existe somente um endpoint na api: **seudominio/transaction**, com os verbos HTTP: **POST**, **GET**, **DELETE**, **PUT**.

A classe *TransactionModel*, é o model da aplicação, responsável pela manipulação do banco de dados, ela representa a entidade *tb_transaction*. No model existem as propriedades: **id UUID**, **movementType String**, **description String**, **category String**, **amount double**, **date DateTime**, **createdAt DateTime** e **updatedAt DateTime**.

A classe *TransactionController*, tem métodos para controle de entrada e manipulação de dados, os métodos estão listados abaixo:
O método **(POST) saveTransaction** não recebe parâmetro e é responsável por salvar as transações no banco de dados, e retorna a transação gravada.
O método **(DELETE) deleteTransaction** recebe como parâmetro o id da transação que será deletada e retorna a confirmação que a transação foi deletada.
O método **(PUT) updateTransaction** recebe como parâmetro o id da transação que será alterada e retorna a transação já alterada
O método **(GET) getOneTransaction** recebe como parâmetro o id da transação, e retorna essa unica transação.
O método **(GET) getAllTransaction** não recebe parâmetro e retorna todos os registros de transações.

Também tem as classes *TransactionRepository* e a *TransactionServices*, que auxiliam na persistência dos dados, auxiliando na regra do negócio.

--------------------------

### 🛠️ Tecnologias e linguagem

Foram utilizadas as seguintes ferramentas:

- [**Java 11**] - Linguagem
- [**Maven**] - Gerenciador de pacotes.
- [**Spring Boot 2.7.3**] - Framework.
- [**Spring Data JPA**] - Persistir de dados, usando Spring Data e Hibernate.
- [**Spring Web**] - Build web, usando Spring MVC e Apache Tomcat como o contêiner.
- [**PostgreSQL Driver**] - Driver para conexão com banco de dados postgres.

----

### Pré-requisitos

É necessário ter instalado as seguintes ferramentas:
[Java](https://www.java.com/pt-BR/), [Maven](https://maven.apache.org/index.html) e o [Git](https://git-scm.com).

---

### 🎲 Executando o projeto

```bash
# Clonar o repositório
$ git clone https://github.com/alxc89/FinancialControl

# Acesse a pasta do projeto no terminal/cmd
$ cd FinancialControl

# Criando o JAR
$ mvn clean package

# Setando as variáveis de ambiente
$ export DB_URL=url.banco
$ export DB_USER=user.name
$ export DB_PASSWORD=password

# Execute a aplicação
$ mvn spring-boot:run
```
<div>
<a href="https://www.linkedin.com/in/alex-cardoso-da-costa-764849bb/">
<img src="https://cdn-icons-png.flaticon.com/512/174/174857.png" alt="linkedin" height="50"></a>

<a href="https://www.instagram.com/alexcaardoso/">
<img src="https://cdn-icons-png.flaticon.com/128/1409/1409946.png" alt="instagram" height="50"></a>


