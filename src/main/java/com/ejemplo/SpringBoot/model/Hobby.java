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
public class Hobby implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    private String hobby;
    private String descripcion;
    
    public Hobby (Long id, String hobby, String descripcion) {
        this.id = id;
        this.hobby = hobby;
        this.descripcion = descripcion;
    }

}
