package com.pepe.Configuraciones;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic DefinicionTopic(){
        return TopicBuilder
                .name("recentchanges_de_wikimedia")
                .build();
    }
    // Sin utilizar
    @Bean
    public NewTopic DefinicionJsonTopic(){
        return TopicBuilder
                .name("jsonTpc")
                .build();
    }
}

