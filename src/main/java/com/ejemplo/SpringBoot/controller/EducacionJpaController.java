
package com.ejemplo.SpringBoot.controller;


import com.ejemplo.SpringBoot.model.Educacion;
import com.ejemplo.SpringBoot.service.IEducacionService;
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
public class EducacionJpaController {
   
    @Autowired    
    private IEducacionService eduServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/educacion")
    public void agregarEducacion (@RequestBody Educacion edu) {
        eduServ.crearEducacion(edu);
    }

    @GetMapping ("/ver/educacion")
    @ResponseBody
    public List<Educacion> verEducacion () {
       return eduServ.verEducacion();
    }      
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{idEdu}")
    public void borrarEducacion (@PathVariable Long id) {
        eduServ.borrarEducacion(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/modificar/educacion/{id}")
    public Educacion modificarEducacion (@PathVariable Long id,
                                     @RequestParam ("institucion") String nuevoInstitucion,
                                     @RequestParam ("titulo") String nuevoTitulo,
                                     @RequestParam ("descripcion") String nuevoDescripcion,
                                     @RequestParam ("referencia") String nuevoReferencia,
                                     @RequestParam ("start") Date nuevoStart,
                                     @RequestParam ("end") Date nuevoEnd) {      


       Educacion edu =  eduServ.buscarEducacion(id);     

             
        edu.setInstitucion(nuevoInstitucion);
        edu.setTitulo(nuevoTitulo);
        edu.setDescripcion(nuevoDescripcion);
        edu.setReferencia(nuevoReferencia);
        edu.setStart(nuevoStart);     
        edu.setEnd(nuevoEnd);  
        
        
        eduServ.crearEducacion(edu);
        
        return edu;
}

}
