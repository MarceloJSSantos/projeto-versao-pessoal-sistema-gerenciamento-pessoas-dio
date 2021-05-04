## Sistema de gerenciamento de pessoas em API REST com Spring Boot
Repositório com a VERSÃO PESSOAL do projeto prático "Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring" da [DIO](https://digitalinnovation.one/)

-----------------------

Neste projeto foi desenvolvido um pequeno sistema para o gerenciamento de pessoas através de uma API REST, criada com o Spring Boot.



#### Desenvolvimento

Foram desenvolvidas as seguintes tarefas:

* Configurações iniciais de um projeto com o Spring Boot Initialzr 
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de pessoas  (Cadastro, leitura, atualização(integral) e remoção de pessoas do sistema) com o padrão arquitetural REST (GET, POST, PUT e DELETE)
* Desenvolvimento de teste unitário para validação da funcionalidade (só para o método createPessoa, verificando a mensagem de retorno)
* Implantação do sistema na nuvem através do Heroku



#### Tecnologias e Dependências utilizadas

- Java 11
- Maven 3.8.1
  - **Lombok**
  - **Map Struct**
  - **H2 Database**
- Spring Boot (2.4.5)
  - **Spring Boot DevTools**
  - **Spring Web**
  - **Spring Data JPA** 

  - **Spring Boot Actuator**
- Git/GitHub para versionamento do código
- Heroku para deploy na nuvem



#### Instalação e Execução

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o endereço ``http://localhost:8080/api/v1`` + RECURSO e visualizar a execução do projeto:

| MÉTODO | RECURSO       | RESULTADO                               |
| ------ | ------------- | --------------------------------------- |
| GET    | /pessoas      | retorna lista de pessoas                |
| GET    | /pessoas/{id} | retorna uma pessoa específica           |
| POST   | /pessoas      | cria uma nova pessoa                    |
| PUT    | /pessoas/{id} | atualiza, de forma integral, uma pessoa |
| DELETE | /pessoas/{id} | deleta uma pessoa                       |

Exemplo de corpo da requisição POST

```json
{
    "nomePrimeiro": "Carlos Cláudia",
    "nomeUltimo": "Santos Caldeira",
    "cpf": "222.830.390-96",
    "dataNascimento": "25-04-1970",
    "telefones": [
        { "tipo": "CELULAR", "numero": "(86)98340-2284" },
        { "tipo": "CASA", "numero": "(86)98001-2284" }
    ]
}
```

Exemplo de uma requisição PUT

```json
{
        "id": 3,
        "nomePrimeiro": "Carlos Cláudia",
        "nomeUltimo": "Santos Caldeira",
        "cpf": "095.729.960-53",
        "dataNascimento": "25-04-1970",
        "telefones": [
            {
                "id": 5,
                "tipo": "CELULAR",
                "numero": "(21)98340-2284"
            },
            {
                "id": 6,
                "tipo": "CASA",
                "numero": "(21)98001-2284"
            }
        ]
    }
```



#### Melhorias futuras

- Desenvolvimento de testes unitários para validação de outras funcionalidades (negócio)
- Desenvolvimento de operações de outros métodos HTTP  (PATCH, HEAD e OPTION)

