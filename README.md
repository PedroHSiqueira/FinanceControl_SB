# FinanceControl_SB 💰📊

**FinanceControl_SB** é uma aplicação backend desenvolvida em **Java + Spring Boot** para gerenciamento financeiro.  
O sistema oferece autenticação com **JWT**, controle de usuários e integração com banco de dados via **JPA/Hibernate**.

## 🚀 Funcionalidades

- 🔑 **Autenticação com JWT** — Login seguro utilizando tokens.
- 👤 **Gestão de Usuários** — Cadastro e controle de contas.
- 💾 **Persistência com JPA/Hibernate** — Integração simplificada com banco de dados relacional.
- 🌐 **API REST** — Pronta para ser consumida por front-ends, mobile ou integrações externas.
- 🐳 **Suporte a Docker** — Ambiente configurado com `docker-compose` e variáveis de ambiente.

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.5.4**
- **Spring Web**
- **Spring Security (JWT)**
- **Spring Data JPA**
- **Maven**
- **Docker & Docker Compose**
- **Banco de Dados (PostgreSQL/MySQL — conforme `.env`)**

## 📂 Estrutura do Projeto

```
├── src/main/java/dev/siqueira/financecontrol/ # Código fonte principal
│ ├── controller/ # Endpoints REST
│ ├── model/ # Entidades JPA
│ ├── repository/ # Interfaces de acesso a dados
│ └── service/ # Regras de negócio
├── pom.xml # Dependências Maven
├── docker-compose.yml # Subida da aplicação + banco de dados
├── .env # Variáveis de ambiente
└── README.md # Documentação
```

## ⚙️ Configuração e Execução

### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/PedroHSiqueira/FinanceControl_SB.git
cd FinanceControl_SB

```

### 2️⃣ Configurar Variáveis de Ambiente
```
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
DB_NAME=finance_db
JWT_SECRET=seu_token_secreto
```

### 3️⃣ Iniciar Docker-Compose
```
docker-compose up --build
```

## 📚 Endpoints Principais
| Método | Endpoint                  | Descrição                     |
|--------|---------------------------|-------------------------------|
| POST   | /auth/login               | Autenticação e geração de JWT |
| POST   | /auth/register            | Cadastro de usuário           |
| GET    | /api/v1/transactions      | Lista de Transações           |
| POST   | /api/v1/transactions      | Cadastro de Transações        |
| PUT    | /api/v1/transactions/{ID} | Atualiza uma transação        |
| DELETE | /api/v1/transactions/{ID} | Deleta uma Transação          |


## 📜 Licença

Este projeto está sob a licença MIT — sinta-se livre para usar e modificar.

