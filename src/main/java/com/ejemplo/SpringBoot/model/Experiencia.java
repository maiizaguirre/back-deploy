package com.ejemplo.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    private String organizacion;
    private String posicion;
    private String descripcion;
    private String referencia;
        
    @JsonFormat(pattern="yyyy-MM-dd")   
    private Date start;
    private Date end;

    public Experiencia (Long id, String organizacion, String posicion, String descripcion, String referencia, Date start, Date end) {
        this.id = id;
        this.organizacion = organizacion;
        this.posicion = posicion;
        this.descripcion = descripcion;
        this.referencia = referencia;
        this.start = start;
        this.end = end;
    }

}
