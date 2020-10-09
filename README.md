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
