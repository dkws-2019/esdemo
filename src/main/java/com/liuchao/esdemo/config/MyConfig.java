package com.liuchao.esdemo.config;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public JestClient jestClient(){
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                        .Builder("http://192.168.0.117:9200")
                        .multiThreaded(true).build());

                return factory.getObject();
    }
}
