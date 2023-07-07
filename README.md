
# Cárdapio-CRUD

Este projeto foi elaborado para demonstrar meus conhecimentos e dominios em Java utilizando o Spring Boot. São pequenos endpoints criados para suprir demandas na hora de criar um cardápio online. 

## Documentação da API

#### Inclui um novo produto

```http
  POST /v1/menu
```

| Body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `productName`      | `string` | **Obrigatório**. O nome do produto que você quer |
| `description`      | `string` | **Obrigatório**. A descrição sobre o produto |
| `image`      | `string` | A imagem do produto |

#### Altera as informações do produto

```http
  PUT /v1/menu/product/${id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id`      | `string` | **Obrigatório**. O ID do produto que você quer alterar|

| Body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `productName`      | `string` | **Obrigatório**. O nome do produto que você quer |
| `description`      | `string` | **Obrigatório**. A descrição sobre o produto |
| `image`      | `string` | A imagem do produto |

#### Retorna uma lista paginada dos produtos ativos

```http
  GET /v1/menu
```

#### Retorna uma lista paginada dos produtos inativos 

```http
  GET /v1/menu/products-inactives
```

#### Retorna o produto detalhado

```http
  GET /v1/menu/product/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id`      | `string` | **Obrigatório**. O ID do produto que você quer detalhar|



#### Remove o produto

```http
  DELETE /v1/menu/product/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id`      | `string` | **Obrigatório**. O ID da produto que você quer remover |

## Stack utilizada

- Spring Boot, maven versão 2.7.13
- Java, versão 11
- dependencias:
    - Spring Boot Actuator
    - Validation
    - Spring Data JPA
    - PostgreSQL Driver
    - Spring Web
    - Lombok


