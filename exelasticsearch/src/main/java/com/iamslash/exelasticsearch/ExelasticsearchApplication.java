package com.iamslash.exelasticsearch;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iamslash.exelasticsearch.person.Person;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.JestResultHandler;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.IndicesExists;
import io.searchbox.indices.aliases.AddAliasMapping;
import io.searchbox.indices.aliases.ModifyAliases;
import io.searchbox.indices.aliases.RemoveAliasMapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class ExelasticsearchApplication {

	public static void main(String[] args) throws IOException {
		doit();
		//SpringApplication.run(ExelasticsearchApplication.class, args);
	}

	public static void doit() throws IOException {
		String indexName = "persons";

		// Create JestClient
		JestClient jestClient = jestClient();

		// Check an index
		JestResult result = jestClient.execute(new IndicesExists.Builder(indexName).build());
		if (!result.isSucceeded()) {
			System.out.println(result.getErrorMessage());
		}

		// Create an index
		jestClient.execute(new CreateIndex.Builder(indexName).build());

		// Create an index with options
		Map<String, Object> settings = new HashMap<>();
		settings.put("number_of_shards", 11);
		settings.put("number_of_replicas", 2);
		jestClient.execute(new CreateIndex.Builder(indexName).settings(settings).build());

		// Create an alias, then remove it
		jestClient.execute(new ModifyAliases.Builder(
				new AddAliasMapping.Builder(
						indexName,
						"p").build()).build());
		JestResult jestResult = jestClient.execute(new ModifyAliases.Builder(
				new RemoveAliasMapping.Builder(
						indexName,
						"p").build()).build());
		if (jestResult.isSucceeded()) {
			System.out.println("Success!");
		} else {
			System.out.println(jestResult.getErrorMessage());
		}

		// Sample JSON for indexing

		// {
		//  "name": "David Sun",
		//  "email": "iamslash@gmail.com",
		//  "friends": ["Damian", "Jaden", "Kungfu"],
		//  "yearsOfjob": 3
		// }

		ObjectMapper mapper = new ObjectMapper();
		JsonNode personJsonNode = mapper.createObjectNode()
				.put("name", "David Sun")
				.put("email", "iamslash@gmail.com")
				.put("yearsOfJob", 2)
				.set("friends",
						mapper.createArrayNode()
						.add("Damian")
						.add("Jaden")
						.add("Kungfu"));
		jestClient.execute(new Index.Builder(personJsonNode.toString()).index("persons").build());

		// Index a document from Map
		Map<String, Object> personHashMap = new LinkedHashMap<>();
		personHashMap.put("name", "David Sun");
		personHashMap.put("email", "iamslash@gmail.com");
		personHashMap.put("yearsOfJob", 2);
		personHashMap.put("friends", Arrays.asList("Damian", "Jaden", "Kungfu"));
		jestClient.execute(new Index.Builder(personHashMap).index(indexName).build());

		// Index a document from POJO
		Person person = new Person();
		person.setName("David Five");
		person.setEmail("damian@gmail.com");
		person.setYearsOfJob(2);
		person.setFriends(Arrays.asList("David", "Jaden", "Kungfu"));
		jestClient.execute(new Index.Builder(person).index(indexName).build());

		Person getResult = jestClient
				.execute(new Get.Builder("persons", "1").build())
				.getSourceAsObject(Person.class);

		// Search documents
		String search = "{\n" +
				"  \"query\": {\n" +
				"    \"bool\": {\n" +
				"      \"must\": [\n" +
				"        { \"match\": { \"name\":   \"David Sun\" }}\n" +
				"      ]\n" +
				"    }\n" +
				"  }\n" +
				"}";
		List<SearchResult.Hit<Person, Void>> searchResults =
				jestClient.execute(new Search.Builder(search).build())
						.getHits(Person.class);

		searchResults.forEach(hit -> {
			System.out.println(String.format("Document %s has score %s", hit.id, hit.score));
		});

		// Update document
		person.setYearsOfJob(3);
		jestClient.execute(new Update.Builder(person).index(indexName).id("1").build());

		// Delete documents
		jestClient.execute(new Delete.Builder("2") .index(indexName) .build());

		// Bulk operations
		Person person1 = new Person();
		person1.setName("John Smith");
		person1.setEmail("john@gmail.com");
		person1.setYearsOfJob(10);
		person1.setFriends(Arrays.asList("David"));

		Person person2 = new Person();
		person2.setName("Kate Smith");
		person2.setEmail("kate@gmail.com");
		person2.setYearsOfJob(10);
		person2.setFriends(Arrays.asList("Damian", "Kungfu"));

		jestClient.execute(new Bulk.Builder().defaultIndex(indexName)
				.addAction(new Index.Builder(person1).build())
				.addAction(new Index.Builder(person2).build())
				.addAction(new Delete.Builder("3").build()) .build());

		// Async operations
		Person person3 = new Person();
		person3.setName("Jane Doe");
		person3.setEmail("jane@gmail.com");
		person3.setYearsOfJob(20);
		person3.setFriends(Arrays.asList("Damian"));

		jestClient.executeAsync( new Index.Builder(person3).build(), new JestResultHandler<JestResult>() {
			@Override public void completed(JestResult result) {
				// handle result
				System.out.println("-------------------------------------------------- completed");
			}
			@Override public void failed(Exception ex) {
				// handle exception
				System.out.println("-------------------------------------------------- failed");
				System.out.println(ex);
			}
		});

	}

	private static JestClient jestClient()
	{
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(
				new HttpClientConfig.Builder("http://localhost:9200")
						.multiThreaded(true)
						.defaultMaxTotalConnectionPerRoute(2)
						.maxTotalConnection(20)
						.connTimeout(10_000)
						.readTimeout(10_000)
						.build());
		return factory.getObject();
	}
}
