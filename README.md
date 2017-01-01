# spring-boot-2-datasources
Projeto para ilustrar os problemas com dois datasources e spring-boot

Como levantar os dois bancos de dados com docker:

# Criando um docker mysql com user e password
sudo docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --name mysql-local -d mysql
# Subindo o mysql criando na linha anterior (quando estiver parado - por exemplo depois de reiniciar)
docker start mysql-local
# Executar um mysql por comandos no mysql que está up
docker exec -it mysql-local mysql -uroot -proot
# Remover caso precisar
docker rm mysql-local

# Criando um docker postgres com user e password
docker run --name local-postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres
# Subindo o postgres criando na linha anterior (quando estiver parado - por exemplo depois de reiniciar)
docker start local-postgres
# Executar um postgres por comandos no postgres que está up
docker run -it --rm --link local-postgres:postgres postgres psql -h postgres -U postgres
# Executar um postgres por comandos no postgres que está up conetando diretamente no banco "casadocodigo"
docker run -it --rm --link local-postgres:postgres postgres psql -h postgres -U postgres -d casadocodigo
# criar novo banco
create database <nome>
# connetar ao banco
\connect <nome>
# sair
\q
