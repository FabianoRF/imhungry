## I'm hungry

Para executar o projeto:

1. Clonar o repositorio, abrir em seu editor(IntelliJ de preferencia)

2. Na pasta raiz do projeto executar `./gradlew bootrun`;

3. Para editar configurações referentes ao BD entrar no arquivo: `src/main/resources/application.properties`

docker run --name imhungry-mysql -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=teste123 -e MYSQL_DATABASE=imhungry -e MYSQL_USER=imhungryuser -e MYSQL_PASSWORD=teste123 mysql