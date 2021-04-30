# Abstract

This is an integration with JDBC template.

# Materials

* [spring mysql @ TIL](https://github.com/iamslash/TIL/blob/master/spring/SpringBoot.md)

# How to run mysql with docker

```console
$ docker run -p3306:3306 --name my-mysql -e MYSQL_ROOT_PASSWORD=1 -e MYSQL_DATABASE=hello -e MYSQL_USER=iamslash -e MYSQL_PASSWORD=1 -d mysql
$ docker ps
$ docker exec -it my-mysql /bin/bash

$ mysql -u iamslash -p
mysql> show databases
mysql> use hello
```

# application.properties

* [application.properties](src/main/resources/application.properties)

# build.gradle

* [build.gradle](build.gradle)

# MySqlRunner.java

* [MySqlRunner.java](src/main/java/com/iamslash/exmysql/MySqlRunner.java)
