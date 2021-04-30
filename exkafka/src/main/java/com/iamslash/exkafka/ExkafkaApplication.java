package com.iamslash.exkafka;

import com.iamslash.exkafka.greeting.Greeting;
import com.iamslash.exkafka.kafka.MessageListener;
import com.iamslash.exkafka.kafka.MessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ExkafkaApplication {

	public static void main(String[] args) throws InterruptedException {

		ConfigurableApplicationContext context = SpringApplication.run(ExkafkaApplication.class, args);

		MessageProducer producer = context.getBean(MessageProducer.class);
		MessageListener listener = context.getBean(MessageListener.class);

		producer.sendMessage("Hello, World!");
		listener.latch.await(10, TimeUnit.SECONDS);

		for (int i = 0; i < 5; i++) {
			producer.sendMessageToPartion("Hello To Partioned Topic!", i);
		}
		listener.partitionLatch.await(10, TimeUnit.SECONDS);

		producer.sendMessageToFiltered("Hello iamslash!");
		producer.sendMessageToFiltered("Hello World!");
		listener.filterLatch.await(10, TimeUnit.SECONDS);

		producer.sendGreetingMessage(new Greeting("Greetings", "World!"));
		listener.greetingLatch.await(10, TimeUnit.SECONDS);

		context.close();
	}

	@Bean
	public MessageProducer messageProducer() {
		return new MessageProducer();
	}

	@Bean
	public MessageListener messageListener() {
		return new MessageListener();
	}

}
