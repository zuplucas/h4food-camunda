# h4food-camunda

Projetinho criado na apresentação do hack4food - Camunda Conceitos Básicos

## 1. Requisitos

Para executar o projeto é necessária a instalação das seguintes ferramentas:

    1. JDK 1.8
    2. Maven 3 (ou superior)
    3. Docker 17.06 (ou superior)
    4. Docker Compose 1.14  (ou superior)

Além disso, para realizar o desenvolvimento é preciso do uso de uma IDE. Atualmente a IDE utilizada é a IntelliJ, contudo, pode também ser utilizado o Eclipse.

## 2. Executando o Projeto

Para executar o projeto no *bash* ou na IDE, inicialmente é preciso iniciar o Docker Compose. Para isso, é preciso apenas executar o seguinte comando.

```sh
$ cd docker
$ docker-compose -f docker-integration up
```

Uma vez com o docker-compose em execução, o projeto pode ser executado via *bash* ou dentro de uma IDE. 

OBS: se houver outros dockers em execução, ou postgresql/stubby4j na máquina, pode ser que dê conflito de portas.


No application.properties está configurado o banco de dados onde estará a base do camunda, conforme está no docker-compose.
```
spring.datasource.url=jdbc:postgresql://postgres:5432/camunda
spring.datasource.username=camunda
spring.datasource.password=camunda
```

