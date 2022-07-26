
package com.ejemplo.SpringBoot.controller;


import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.service.IExperienciaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienciaJpaController {
   
    @Autowired    
    private IExperienciaService expServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/experiencia")
    public void agregarExperiencia (@RequestBody Experiencia exp) {
        expServ.crearExperiencia(exp);
    }

    @GetMapping ("/ver/experiencia")
    @ResponseBody
    public List<Experiencia> verExperiencia () {
       return expServ.verExperiencia();
    }      
    
    @PreAuthorize("hasRole('ADMIN')")   
    @DeleteMapping ("/delete/{idExp}")
    public void borrarExperiencia (@PathVariable Long id) {
        expServ.borrarExperiencia(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/modificar/experiencia/{id}")
    public Experiencia modificarExperiencia (@PathVariable Long id,
                                     @RequestParam ("organizacion") String nuevoOrganizacion,
                                     @RequestParam ("posicion") String nuevoPosicion,
                                     @RequestParam ("descripcion") String nuevoDescripcion,
                                     @RequestParam ("referencia") String nuevoReferencia,
                                     @RequestParam ("start") Date nuevoStart,
                                     @RequestParam ("end") Date nuevoEnd) {      


       Experiencia exp =  expServ.buscarExperiencia(id);     

             
        exp.setOrganizacion(nuevoOrganizacion);
        exp.setPosicion(nuevoPosicion);
        exp.setDescripcion(nuevoDescripcion);
        exp.setReferencia(nuevoReferencia);
        exp.setStart(nuevoStart);     
        exp.setEnd(nuevoEnd);   
        
        expServ.crearExperiencia(exp);
        
        return exp;
}


}
