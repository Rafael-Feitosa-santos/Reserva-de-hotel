
# Reserva de Hotel

<hr>
Todos os micros serviços foram desenvolvidos utlizando a versão <b>21 do Java.</b>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Mysql](https://img.shields.io/badge/MYSQL-blue?style=for-the-badge&logo=mysql&logoColor=black)

[![My Skills](https://skillicons.dev/icons?i=docker,&perline=3)](https://skillicons.dev)


## 📑 Swagger Documentação

- Microserviço de Cadastro de Hotel - http://localhost:8080/swagger-ui/index.html
- Microserviço de Reserva - http://localhost:6060/swagger-ui/index.html

### Docker

Para executar os docker compose dos microservicos nas pastas dos projetos.
```sh
docker compose up -d
```

## Serviços em nossa aplicação
- [x] Mysql
- [x] Discovery
- [x] Gateway
- [x] Cadastro_hotel
- [x] Reserva

### Serviço de Discovery
Discovery-reserva - O objetivo desse serviço é registrar todos os serviços utilizados no projeto para facilitar a localização e manutenção dos serviços. A rastreabilidade dos serviços se torna rápida e eficaz para eventuais manutenções.
Para acessar a página do discovery: http://localhost:5050

### Serviço de Gateway
Gateway - O objetivo desse serviço é disponibilizar para o cliente um único local de chamada para os serviços utilizados no projeto, centralizando todos os serviços em um único endereço e porta ip.
Para acessar os serviços: http://localhost:5051

### Serviço de Cadastro Hotel

Cadastro_hotel - O objetivo desse serviço é disponibilizar 
uma api para que o usuário, possa realizar o CRUD do cadastro de hoteis.

### Serviço de Reserva

reserva - O objetivo desse serviço é disponibilizar
uma api para que o usuário, possa realizar criação de reservas.


## 🔧 Instalação

```shell
git clone https://github.com/Rafael-Feitosa-santos/Reserva-de-hotel.git
```