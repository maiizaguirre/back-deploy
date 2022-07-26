
package com.ejemplo.SpringBoot.controller;


import com.ejemplo.SpringBoot.model.Aptitud;
import com.ejemplo.SpringBoot.service.IAptitudService;
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
public class AptitudJpaController {
   
    @Autowired    
    private IAptitudService aptServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/aptitud")
    public void agregarAptitud (@RequestBody Aptitud apt) {
        aptServ.crearAptitud(apt);
    }

    @GetMapping ("/ver/aptitud")
    @ResponseBody
    public List<Aptitud> verAptitud () {
       return aptServ.verAptitud();
    }      
    @PreAuthorize("hasRole('ADMIN')")    
    @DeleteMapping ("/delete/{idAptitud}")
    public void borrarAptitud (@PathVariable Long id) {
        aptServ.borrarAptitud(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/modificar/aptitud/{id}")
    public Aptitud modificarAptitud (@PathVariable Long id,
                                     @RequestParam ("aptitud") String nuevoAptitud,
                                     @RequestParam ("descripcion") String nuevoDescripcion) {      


       Aptitud apt =  aptServ.buscarAptitud(id);     

             
        apt.setAptitud(nuevoAptitud);
        apt.setDescripcion(nuevoDescripcion);
        
        
        aptServ.crearAptitud(apt);
        
        return apt;
}

}