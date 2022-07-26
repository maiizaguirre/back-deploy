
package com.ejemplo.SpringBoot.controller;


import com.ejemplo.SpringBoot.model.Hobby;
import com.ejemplo.SpringBoot.service.IHobbyService;
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
public class HobbyJpaController {
   
    @Autowired    
    private IHobbyService hobbyServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/hobby")
    public void agregarHobby (@RequestBody Hobby hobby) {
        hobbyServ.crearHobby(hobby);
    }

    @GetMapping ("/ver/hobby")
    @ResponseBody
    public List<Hobby> verHobby () {
       return hobbyServ.verHobby();
    }      
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{idHobby}")
    public void borrarHobby (@PathVariable Long id) {
        hobbyServ.borrarHobby(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/modificar/hobby/{id}")
    public Hobby modificarHobby (@PathVariable Long id,
                                     @RequestParam ("hobby") String nuevoHobby,
                                     @RequestParam ("descripcion") String nuevoDescripcion) {      


       Hobby hobby =  hobbyServ.buscarHobby(id);     

             
        hobby.setHobby(nuevoHobby);
        hobby.setDescripcion(nuevoDescripcion);
        
        
        hobbyServ.crearHobby(hobby);
       
        return hobby;
}

}