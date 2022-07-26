
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
public class Persona implements Serializable {
    
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dni;    
    private String nombre;
    private String apellido;
    private String fechaNac;
    private String celular;
    private String email;
    private String fotoPerfil;
    private String fotoPortada;
    private String descripcion;
    private String ciudad;
    private String provincia;
    private String pais;

       public Persona () {
    }
    
    public Persona(Long id, String dni, String nombre, String apellido, String fechaNac, String celular, String email, String fotoPerfil, String fotoPortada, String descripcion, String ciudad, String provincia, String pais) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.email = email;
        this.fotoPerfil = fotoPerfil;
        this.fotoPortada = fotoPortada;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    }

}
