package com.craw.data;

import com.craw.data.service.craw.CrawDataService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
public class CrawDataApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(CrawDataApplication.class, args);

        // Run application and craw data to store into data.txt file
        CrawDataService crawDataService = (CrawDataService) context.getBean("crawDataService");
        // crawDataService.crawData();
    }
}
