package com.iamslash.wfmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WfmongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WfmongoApplication.class, args);
    }
}
