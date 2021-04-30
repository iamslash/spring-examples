//package com.iamslash.exelasticsearch.person;
//
//import com.iamslash.exelasticsearch.config.ElasticsearchConfig;
//import org.elasticsearch.action.DocWriteResponse;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ExelasticsearchApplication.class)
//class ElasticSearchManualTest {
//
//  private List<Person> listOfPersons = new ArrayList<>();
//  private Client client = null;
//
//  @Before
//  public void setUp() throws UnknownHostException {
//    Person person1 = new Person(10, "David Sun", new Date());
//    Person person2 = new Person(25, "Like Chat", new Date());
//    listOfPersons.add(person1);
//    listOfPersons.add(person2);
//
//    client = new PreBuiltTransportClient(
//        Settings
//            .builder()
//            .put("client.transport.sniff", true)
//            .put("cluster.name","elasticsearch").build())
//        .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//  }
//
//  @Test
//  public void givenJsonString_whenJavaObject_thenIndexDocument() {
//    String jsonObject = "{\"age\":20,\"dateOfBirth\":1471466076564,\"fullName\":\"John Doe\"}";
//    IndexResponse response = client
//        .prepareIndex("people", "Doe")
//        .setSource(jsonObject, XContentType.JSON)
//        .get();
//    String index = response.getIndex();
//    String type = response.getType();
//
//    assertEquals(DocWriteResponse.Result.CREATED, response.getResult());
//    assertEquals(index, "people");
//    assertEquals(type, "Doe");
//  }
//
//}