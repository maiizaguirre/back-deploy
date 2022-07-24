
package com.ejemplo.SpringBoot.controller;


import com.ejemplo.SpringBoot.dto.AboutDto;
import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaController {
   
    @Autowired    
    private IPersonaService persoServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Persona pers) {
        persoServ.crearPersona(pers);
    }

    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas () {
       return persoServ.verPersonas();
    }      

    @GetMapping ("/detail/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable Long id){
        return persoServ.buscarPersona(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona (@PathVariable Long id) {
        persoServ.borrarPersona(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/modificar/persona/{id}")
    public Persona modificarPersona (@PathVariable Long id,
                                     @RequestBody AboutDto aboutDto) {      

//busco la persona
Persona perso =  persoServ.buscarPersona(id);     

        perso.setNombre(aboutDto.getNombre());
        perso.setApellido(aboutDto.getApellido());
        perso.setCelular(aboutDto.getCelular());
        perso.setEmail(aboutDto.getEmail());
        perso.setDescripcion(aboutDto.getDescripcion());
    
        persoServ.crearPersona(perso);
        //retorna la nueva persona
        return perso;
}


}
