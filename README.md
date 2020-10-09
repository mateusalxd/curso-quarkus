# Anotações do curso de Quarkus

- para começar é necessário baixar a [GraalVM](https://www.graalvm.org/downloads/)
- existe um [site](https://code.quarkus.io/) que facilita a criação do projeto com as dependências que se quer utilizar
- após descompactar e abrir o projeto, é necessário configurar o projeto para utilizar a **GraalVM** (Java Build Path)
- para executar a aplicação utilizar

```bash
./mvnw compile quarkus:dev
```

- para configurar a geração de uma imagem nativa e executá-la, seguir os passar [deste site](https://quarkus.io/guides/building-native-image)
- ao usar `quarkus:dev` é habilitado o `live coding`
- para acompanhar o curso foi usando um banco de dados mysql através de um container

```docker
docker run -d --name servidor-mysql -e MYSQL_DATABASE=bitcoin -e MYSQL_USER=bitcoin -e MYSQL_PASSWORD=123 -e MYSQL_ROOT_PASSWORD=123456 -p 3306:3306 mysql:latest

# acessar o container para criar as tabelas
docker exec -it servidor-mysql mysql -u bitcoin -p
```

```sql
CREATE TABLE `Usuario` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(50) NOT NULL,
	`cpf` VARCHAR(14) NOT NULL,
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(100) NOT NULL,
	PRIMARY KEY(`id`)) ENGINE=InnoDB;

CREATE TABLE `Ordem` (
	`id` int NOT NULL AUTO_INCREMENT,
	`preco` decimal(6,2) NOT NULL,
	`tipo` VARCHAR(20) NOT NULL,
	`data` datetime NOT NULL,
	`status` VARCHAR(30) NOT NULL,
	`user_id` int NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`user_id`) REFERENCES `Usuario` (`id`)) ENGINE=InnoDB;
```
