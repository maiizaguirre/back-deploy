package com.ejemplo.SpringBoot.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Idioma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    private String idioma;
    private String nivel;
    private String descripcion;
    
    public Idioma (Long id, String idioma, String nivel, String descripcion) {
        this.id = id;
        this.idioma = idioma;
        this.nivel = nivel;
        this.descripcion = descripcion;
    }

   
    
}