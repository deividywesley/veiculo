# Api Veiculo


## Requisitos do projeto

- Gradle 6.6
- OpenJDK 11
- Docker

## Configurações do projeto

Executar o comando **docker-compose** dentro da pasta compose do projeto para subir o container:

```bash
docker-compose up -d
```


Caso seja necessário alterar as configurações do BD devido a alterações no docker-compose.yaml, editar o arquivo application.properties e alterar as propriedades abaixo:

```
spring.datasource.url=jdbc:mysql://localhost:3306/api
spring.datasource.username=root
spring.datasource.password=123456
```

Todas as entidades necessárias são criadas automaticamente pela aplicação através de scripts do liquibase.

### Build do projeto

```bash
gradle clean build
```

### Executar

```bash
gradle clean bootRun
```

### Construir executável

```bash
gradle clean bootJar
```

  

