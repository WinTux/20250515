package com.pepe.kafka;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import com.pepe.Configuraciones.CambiosDeWikimediaHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class CambiosDeWikimediaProducer {
    private static final Logger LOGGER
            = LoggerFactory
            .getLogger(CambiosDeWikimediaProducer.class);
    KafkaTemplate<String,String> kafkaTemplate;
    public CambiosDeWikimediaProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void enviarMensaje() throws InterruptedException {
        String topic = "recentchanges_de_wikimedia";
        BackgroundEventHandler evento = new CambiosDeWikimediaHandler(topic, kafkaTemplate);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        BackgroundEventSource.Builder builder =
                new BackgroundEventSource
                    .Builder(
                       evento,
                       new EventSource
                           .Builder(URI.create(url)));
        BackgroundEventSource eventSource
                = builder.build();
        eventSource.start();
        // Que espere 5min para volver a recolectar datos
        TimeUnit.MINUTES.sleep(5);
        //kafkaTemplate.send("nombrecitoTpc",mensaje);
    }
}
