package com.pepe.consum.Models;

import jakarta.persistence.*;

@Entity
@Table(name="wiki_cambios")
public class RegistroWikimedia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Lob //Para textos extremadamente largos
    private String wikiDatosDeEvento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWikiDatosDeEvento() {
        return wikiDatosDeEvento;
    }

    public void setWikiDatosDeEvento(String wikiDatosDeEvento) {
        this.wikiDatosDeEvento = wikiDatosDeEvento;
    }
}
