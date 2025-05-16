package com.pepe.Configuraciones;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.pepe.kafka.CambiosDeWikimediaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class CambiosDeWikimediaHandler implements BackgroundEventHandler {
    // Clase que se encarga de recolectar los objetos JSON desde stream.wikimedia
    // Utiliza Balckground EventHandler para recolectarlo en parralelo (hilo secundario)
    KafkaTemplate<String,String> kafkaTemplate;
    private String topic;
    private static final Logger LOGGER
            = LoggerFactory
            .getLogger(CambiosDeWikimediaHandler.class);
    // Se inyecta kafkaTemplate mediante constructor, tambien se recibe el topic
    public CambiosDeWikimediaHandler(String topic, KafkaTemplate<String,String> kafkaTemplate){
        super();
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        // Este metodo se encarga de recibir cada objeto y publicarlo en kafka
        // Solo necesitamos implemetar este metodo
        LOGGER.info("Se envía mensaje: "+ messageEvent.getData());
        kafkaTemplate.send(topic,messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
