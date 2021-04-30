# Abstract

This is an integration with [Jest client](https://github.com/searchbox-io/Jest).

# Materials

* [Spring and Elasticsearch @ github](https://github.com/ahnjunwoo/elasticsearchDockerExam)
* [Spring Data Elasticsearch - Reference Documentation](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#reference)
* [Jest – Elasticsearch Java Client](https://www.baeldung.com/elasticsearch-jest)

# How to run Elasticsearch with docker

## Single elasticsearch

```console
$ git clone git@github.com:ahnjunwoo/elasticsearchDockerExam.git
$ cd elasticsearchDockerExam
$ docker-compose up -d

$ curl localhost:9200/_cat 
```

open [kibana @ localhost](http://localhost:5601)

# Upload sample data

* [Loading sample data @ elastic](https://www.elastic.co/guide/kr/kibana/current/tutorial-load-dataset.html)

```bash
$ cd ~/my/etc/esdata

# Download data
$ wget https://download.elastic.co/demos/kibana/gettingstarted/shakespeare_6.0.json
$ wget https://download.elastic.co/demos/kibana/gettingstarted/accounts.zip
$ wget https://download.elastic.co/demos/kibana/gettingstarted/logs.jsonl.gz
$ unzip accounts.zip
$ gunzip logs.jsonl.gz

# Set up mappings
$ curl -X PUT "localhost:9200/shakespeare?pretty" -H 'Content-Type: application/json' -d'
{
 "mappings": {
  "doc": {
   "properties": {
    "speaker": {"type": "keyword"},
    "play_name": {"type": "keyword"},
    "line_id": {"type": "integer"},
    "speech_number": {"type": "integer"}
   }
  }
 }
}
'

$ curl -X PUT "localhost:9200/logstash-2015.05.18?pretty" -H 'Content-Type: application/json' -d'
{
  "mappings": {
    "log": {
      "properties": {
        "geo": {
          "properties": {
            "coordinates": {
              "type": "geo_point"
            }
          }
        }
      }
    }
  }
}
'

$ curl -X PUT "localhost:9200/logstash-2015.05.19?pretty" -H 'Content-Type: application/json' -d'
{
  "mappings": {
    "log": {
      "properties": {
        "geo": {
          "properties": {
            "coordinates": {
              "type": "geo_point"
            }
          }
        }
      }
    }
  }
}
'

$ curl -X PUT "localhost:9200/logstash-2015.05.20?pretty" -H 'Content-Type: application/json' -d'
{
  "mappings": {
    "log": {
      "properties": {
        "geo": {
          "properties": {
            "coordinates": {
              "type": "geo_point"
            }
          }
        }
      }
    }
  }
}
'

# Upload data sets
$ curl -H 'Content-Type: application/x-ndjson' -XPOST 'localhost:9200/bank/account/_bulk?pretty' --data-binary @accounts.json
$ curl -H 'Content-Type: application/x-ndjson' -XPOST 'localhost:9200/shakespeare/_bulk?pretty' --data-binary @shakespeare.json
$ curl -H 'Content-Type: application/x-ndjson' -XPOST 'localhost:9200/_bulk?pretty' --data-binary @logs.jsonl

# Check indexes
$ curl -X GET localhost:9200/_cat/indices?v
```

# build.gradle

```gradle
plugins {
	id 'org.springframework.boot' version '2.2.6.RELEASE'
	id 'io.spring.dependency-management' version '1.0.9.RELEASE'
	id 'java'
}

group = 'com.iamslash'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation('org.springframework.boot:spring-boot-starter-test') {
		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	}

	implementation 'org.springframework.data:spring-data-elasticsearch:4.0.0.RELEASE'
}

test {
	useJUnitPlatform()
}
```

