# Abstract

This is an Spring boot application with postgresql.

# Materials

* [spring postgres @ TIL](https://github.com/iamslash/TIL/blob/master/spring/SpringBoot.md)

# Code style 

* [google-java-format plugin](https://gerrit.cloudera.org/Documentation/dev-intellij.html#_google_java_format_plugin)
* [Code style settings](https://gerrit.cloudera.org/Documentation/dev-intellij.html#_code_style_settings)

# How to run postgresql with docker

```console
$ docker run -p 5432:5432 -d -e POSTGRES_PASSWORD=1 -e POSTGRES_USER=iamslash -e POSTGRES_DB=exmeetup --rm --name my-postgres postgres
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
