package com.iamslash.exbasic.hello;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class HelloService {
    String name = "Hello Service";

    @PostConstruct
    public void postContruct() {
        System.out.println(name);
    }

}
