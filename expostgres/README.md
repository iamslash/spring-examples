# Abstract

This is an integration with JDBC template.

# Materials

* [spring postgres @ TIL](https://github.com/iamslash/TIL/blob/master/spring/SpringBoot.md)

# How to run postgresql with docker

```console
$ docker run -p 5432:5432 -d -e POSTGRES_PASSWORD=1 -e POSTGRES_USER=iamslash -e POSTGRES_DB=hello --rm --name my-postgres postgres
$ docker ps
$ docker exec -it postgres_boot /bin/bash
$ su - postgres

$ psql -U iamslash -W hello
> \list
> \dt
> SELECT * FROM account;
```

# application.properties

* [application.properties](src/main/resources/application.properties)

# build.gradle

* [build.gradle](build.gradle)

# PostgresRunner.java

* [PostgresRunner.java](src/main/java/com/iamslash/exmysql/PostgresRunner.java)
