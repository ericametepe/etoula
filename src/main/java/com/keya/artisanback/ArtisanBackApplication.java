package com.keya.artisanback;

import com.keya.artisanback.exposition.InitDataSet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ArtisanBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtisanBackApplication.class, args);
    }

    @Bean
    @ConditionalOnProperty(value = "initial-import.enabled",havingValue = "true")
    public InitDataSet dataSet() {
        return new InitDataSet();
    }

}
