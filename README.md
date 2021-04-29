<h2>Books API</h2>

<h2>Desenvolvimento de uma api reativa com spring boot</h2>


Pré-requisitos:
* Java 8 ou versões superiores.
* Spring Webflux
* Spring Data
* Junit
* Sl4j
* Reactor
* Maven 3.6.3 ou versões superiores.
* Amazon AWS Cli
* DynamoDB

Dynamo:
```shell script
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
```

Listar as tabelas criadas:
```shell script
aws dynamodb list-tables --endpoint-url http://localhost:8000
```

Apliquei os conhecimentos obtidos no curso "Criando seu gerenciador de super heróis da Marvel e da DC em uma API reativa com Spring Boot" da Digital Innovation One
Link para o projeto de estudo : https://github.com/Kamilahsantos/Heroes-SpringWebflux-API
