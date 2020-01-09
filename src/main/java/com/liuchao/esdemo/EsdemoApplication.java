package com.liuchao.esdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
//@EnableElasticsearchRepositories("com.liuchao.esdemo.repository")
public class EsdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsdemoApplication.class, args);
    }

}
