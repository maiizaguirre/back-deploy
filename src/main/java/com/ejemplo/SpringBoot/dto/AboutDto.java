
package com.ejemplo.SpringBoot.dto;
import javax.validation.constraints.NotBlank;



public class AboutDto {

@NotBlank
private String nombre;
@NotBlank
private String apellido;
@NotBlank
private String email;
@NotBlank
private String celular;
@NotBlank
private String descripcion;

    
public AboutDto() {}

public AboutDto (@NotBlank String nomnbre, @NotBlank String apellido, @NotBlank String email, @NotBlank String celular, @NotBlank String descripcion) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.descripcion = descripcion;
    this.celular = celular; 
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
