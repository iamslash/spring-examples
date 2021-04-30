package com.iamslash.exjpa.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HelloEventHandler implements ApplicationListener<HelloEvent> {
    @Autowired
    ApplicationEventPublisher publishEvent;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up");
    }

    @Override
    public void onApplicationEvent(HelloEvent evt) {
        publishEvent.publishEvent("I got it " + evt.getData());
    }
}
