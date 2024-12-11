# Sistema de Gerenciamento de Sites Favoritos

Este é um sistema Java para gerenciar sites favoritos dos usuários. O sistema permite cadastro de usuários e sites favoritos com diferentes categorias.

## Pré-requisitos

- Java JDK 11 ou superior
- Maven
- Docker e Docker Compose
- Git

## Configuração do Ambiente

### 1. Estrutura do Projeto

```bash
bookmarks/
├── docker-compose.yml
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── bookmarks/
                    ├── model/
                    ├── dao/
                    ├── service/
                    └── ui/
```

### 2. Como Executar

- Clone o projeto:
```bash
git clone [url-do-repositorio]
cd bookmarks
```

- Inicie o banco de dados PostgreSQL:
```bash

docker-compose up -d
```

- Verifique se o container está rodando:
```bash
docker ps
```

- Compile o projeto:
```bash
mvn clean package
```

- Execute a aplicação:
```bash
java -jar target/bookmarks-1.0-jar-with-dependencies.jar
```

## Funcionalidades

1. **Gestão de Usuários**:
  * Cadastro de usuário (chave de acesso com 6 caracteres)
  * Login/Logout
  * Atualização de perfil
  * Exclusão de conta

2. **Gestão de Sites**:
  * Adicionar sites favoritos
  * Categorizar sites
  * Listar sites por usuário
  * Editar e excluir sites

## Categorias Disponíveis
* Educação
* Entretenimento
* Notícias
* Tecnologia
* Redes Sociais
