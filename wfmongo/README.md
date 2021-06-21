# Abstract

This is an webFlux integration with mongoDB.

# Materials

* [spring mongodb @ TIL](https://github.com/iamslash/TIL/blob/master/spring/SpringBoot.md)

# How to run mongodb with docker

```console
$ docker run -d -p 27017:27017 --rm --name my-mongo mongo

$ docker exec -it my-mongo bash
$ mongo
```

# application.properties

* [application.properties](src/main/resources/application.properties)

# build.gradle

* [build.gradle](build.gradle)
