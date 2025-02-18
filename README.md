# API Rest para Controle de Contatos

## Descrição do Projeto
Este projeto tem como objetivo criar uma API Rest para gerenciar um sistema de cadastro de Pessoas e seus respectivos Contatos. Cada Pessoa pode ter vários Contatos associados, permitindo operações CRUD (Criar, Ler, Atualizar, Deletar) em ambas as entidades.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3.4.2
- Spring Data JPA / Hibernate
- Banco de Dados  H2
- Documentação da API com OpenAPI (Swagger)

## 🔥 Funcionalidades 

### 🧑‍💼 CRUD de Pessoas
1. Criar Pessoa
2. Obter Pessoa por ID
3. Obter Pessoa por ID para mala direta
4. Listar todas as Pessoas
5. Atualizar Pessoa por ID
6. Deletar Pessoa por ID

### 📞 CRUD de Contatos
1. Adicionar um novo Contato a uma Pessoa
2. Obter Contato por ID
3. Listar todos os Contatos de uma Pessoa
4. Atualizar Contato por ID
5. Deletar Contato por ID


## Modelagem de Dados

### 📌 Pessoa
- `id` (Long) - **PK, único, não pode ser nulo**
- `nome` (String) - **Obrigatório**
- `endereco` (String) - Opcional
- `cep` (String) - Opcional
- `cidade` (String) - Opcional
- `uf` (String) - Opcional

### 📌 Contato
- `id` (Long) - **PK, único, não pode ser nulo**
- `tipoContato` (Integer) - **Obrigatório** (0 - Telefone, 1 - Celular)
- `contato` (String) - **Obrigatório**
- `pessoa` (Pessoa) - **Relacionamento ManyToOne**
## Endpoints

## 🌍 Endpoints Necessários

### 🧑‍💼 Pessoa
| Método | Endpoint | Descrição |
|--------|-------------|-------------|
| `POST` | `/api/pessoas` | Criar uma nova Pessoa |
| `GET` | `/api/pessoas/{id}` | Retorna os dados de uma Pessoa por ID |
| `GET` | `/api/pessoas/maladireta/{id}` | Retorna os dados de uma Pessoa para mala direta |
| `GET` | `/api/pessoas` | Lista todas as Pessoas |
| `PUT` | `/api/pessoas/{id}` | Atualiza uma Pessoa existente |
| `DELETE` | `/api/pessoas/{id}` | Remove uma Pessoa por ID |

### 📞 Contato
| Método | Endpoint | Descrição |
|--------|-------------|-------------|
| `POST` | `/api/contatos/` | Adiciona um novo Contato a uma Pessoa |
| `GET` | `/api/contatos/{id}` | Retorna os dados de um Contato por ID |
| `GET` | `/api/contatos/pessoa/{idPessoa}` | Lista todos os Contatos de uma Pessoa |
| `PUT` | `/api/contatos/{id}` | Atualiza um Contato existente |
| `DELETE` | `/api/contatos/{id}` | Remove um Contato por ID |

## Regras de Negócio
- Cada Pessoa pode ter vários Contatos
- Cada Contato deve estar associado a uma Pessoa
- O endpoint de mala direta retorna apenas os dados necessários no formato DTO

## Configuração do Projeto

### Requisitos
- Java 21
- Maven
- Banco de Dados MySQL, MariaDB, PostgreSQL ou H2

  
🔹 Clonando o Repositório
Para obter o código-fonte do projeto, execute o seguinte comando no terminal:

 git clone https://github.com/michellemadeira1/AgendaContato.git

🔹 Buildando e Rodando no Eclipse
Abra o Eclipse e importe o projeto:

Vá em File > Import... > Maven > Existing Maven Projects.
Selecione a pasta onde o projeto foi clonado e clique em Finish.

🔹 Build e execução:

No Eclipse, vá até a classe principal do projeto (com @SpringBootApplication).
Clique com o botão direito e selecione Run As > Spring Boot App.

🔹 Acesse a API via Swagger:
http://localhost:8080/swagger-ui.html

### Configuração do Banco de Dados H2 (`application.properties`)
```properties
#H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.database-plataform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=drop-and-create
spring.datasource.url=jdbc:h2:mem:produtos
spring.datasource.username=sa
spring.datasource.password=
