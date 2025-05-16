package com.pepe;

import com.pepe.kafka.CambiosDeWikimediaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {
    @Autowired
    private CambiosDeWikimediaProducer cambiosWikimediaPro;
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cambiosWikimediaPro.enviarMensaje();
    }
}
