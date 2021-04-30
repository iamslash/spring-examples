# Abstract

This is an integration with cassandra.

# Materials

* [cassandra @ TIL](https://github.com/iamslash/TIL/blob/master/spring/SpringBoot.md)
* [Introduction to Spring Data Cassandra @ baeldung](https://www.baeldung.com/spring-data-cassandra-tutorial)
  * [src](https://github.com/eugenp/tutorials/tree/master/persistence-modules/spring-data-cassandra)
* [Spring Boot Cassandra CRUD example with Spring Data](https://bezkoder.com/spring-boot-cassandra-crud/#Configure_Spring_Data_Cassandra)
  * [src](https://github.com/bezkoder/spring-boot-data-cassandra)

# How to launch cassandra

```bash
$ docker run --rm -p 9042:9042 --name my-cassandra -d cassandra
$ docker exec -it my-cassandra bash
> cqlsh
cqlsh> create keyspace iamslash with replication={'class':'SimpleStrategy', 'replication_factor':1};
cqlsh> use iamslash;
cqlsh:iamslash> CREATE TABLE tutorial(
            ...    id timeuuid PRIMARY KEY,
            ...    title text,
            ...    description text,
            ...    published boolean
            ... );
cqlsh:iamslash> CREATE CUSTOM INDEX idx_title ON iamslash.tutorial (title)
            ... USING 'org.apache.cassandra.index.sasi.SASIIndex'
            ... WITH OPTIONS = {
            ... 'mode': 'CONTAINS',
            ... 'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer',
            ... 'case_sensitive': 'false'};
```

# application.properties

* [application.properties](src/main/resources/application.properties)

# build.gradle

* [build.gradle](build.gradle)
