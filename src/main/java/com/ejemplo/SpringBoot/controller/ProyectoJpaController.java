
package com.ejemplo.SpringBoot.controller;


import com.ejemplo.SpringBoot.model.Proyecto;
import com.ejemplo.SpringBoot.service.IProyectoService;
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
public class ProyectoJpaController {
   
    @Autowired    
    private IProyectoService proyServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/proyecto")
    public void agregarProyecto(@RequestBody Proyecto proy) {
        proyServ.crearProyecto(proy);
    }

    @GetMapping ("/ver/proyecto")
    @ResponseBody
    public List<Proyecto> verProyecto () {
       return proyServ.verProyecto();
    }      
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{idProyecto}")
    public void borrarProyecto (@PathVariable Long id) {
        proyServ.borrarProyecto(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/modificar/proyecto/{id}")
    public Proyecto modificarProyecto (@PathVariable Long id,
                                     @RequestParam ("nombre") String nuevoNombre,
                                     @RequestParam ("descripcion") String nuevoDescripcion) {      


       Proyecto proy =  proyServ.buscarProyecto(id);     

             
        proy.setNombre(nuevoNombre);
        proy.setDescripcion(nuevoDescripcion);
        
        
        proyServ.crearProyecto(proy);
        
        return proy;
}

}