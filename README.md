# ITAU - DESAFIO TESTE API #


Este documento tem como objetivo exibir as informações da API de teste construída para o desafio proposto pelo Itaú para a vaga de Backend Java.

### Descrição do Projeto ###

O projeto trata-se de uma API Rest que possui o objetivo de validar um password, devendo obedecer algumas regras específicas, tais como:
* Nove ou mais caracteres.
* Ao menos 1 dígito.
* Ao menos 1 letra minúscula.
* Ao menos 1 letra maiúscula.
* Ao menos 1 caractere especial.
    * Considere como especial os seguintes caracteres: !@#$%^&*()-+
* Não possuir caracteres repetidos dentro do conjunto

E esta API deverá emitir apenas uma resposta booleana 'true' ou 'false' considerando respectivamente se o password informado é válido ou não.

## Glossário

* Artefato Repositório
* Tecnologias
* Práticas Desenvolvimento
* Iniciando ...
* Endpoints
* Swagger
* Teste Interface API Web
* Autor

## Artefato Repositorio

* desafiocase contendo o MS ms-senha (artefato da API)

## Tecnologias

* Spring Boot 2.7.5
* Java 11
* JUnit
* Intellij

## Práticas Desenvolvimento

* Clean Architeture
* Clean Code
* SOLID


## Iniciando ...

* Fazendo o download do artefato:
    * `git clone https://github.com/israelprojeto27/desafio-case-itau`

* Acessando diretório:
    - `cd desafio-case-itau`

A partir do diretório informado será possível acessar todo o código-fonte do referido artefato.


## Endpoints

Para esta API foi construída apenas um endpoint que será responsável para referida validação sobre o password informado.

Para a ilustração do endpoint a seguir, vai ser utilizado o termo <BASE_URL> apenas para designar, de forma genérica, a URL do servidor onde está deployada a API, podendo ser por `http://localhost:8097`.

* Enviar um input de password para validação:
    * `<BASE_URL>/senha/valida-senha`
        * Método requisição Http: POST.
        * Vale ressaltar que para o funcionamento deste endpoint é necessário um Body na requisição no formato JSON.
        * Exemplo do body:
            * `{"input": "Aabv#12P3Oa"}`
        * Exemplo cUrl para realizar a requisição:
```shell script  
       curl --location --request POST 'http://localhost:8097/senha/valida-senha' \
        --header 'Content-Type: application/json' \
        --data-raw '{
        "input": "Aabv#12P3Oa"
        }'
```  

## Swagger

Dentro do projeto da API `desafio-case-itau` é possível acessar o documento Swagger da aplicação que contém as informações do endpoint implementado para esta API.

Quando a aplicação for iniciada localmente, este documento poderá ser acessado através através da seguinte URL:
* http://localhost:8097/swagger-ui/index.html



## Autor

* Autor: Israel Dias Barreto
