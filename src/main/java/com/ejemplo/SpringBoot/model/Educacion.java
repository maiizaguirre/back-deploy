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
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    private String institucion;
    private String titulo;
    private String descripcion;
    private String referencia;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date start;
    private Date end;

    public Educacion (Long id, String institucion, String titulo, String descripcion, String referencia, Date start, Date end) {
        this.id = id;
        this.institucion = institucion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.referencia = referencia;
        this.start = start;
        this.end = end;
    }

   
    
}