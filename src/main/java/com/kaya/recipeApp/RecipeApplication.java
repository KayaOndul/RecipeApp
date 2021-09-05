package com.kaya.recipeApp;

import com.github.cloudyrock.spring.v5.EnableMongock;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoAuditing
@EnableMongock
@OpenAPIDefinition(info = @Info(title = "Recipe Application API", version = "0.0.1", description = "Recipe Application Endpoints"))
public class RecipeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeApplication.class, args);
    }

}
