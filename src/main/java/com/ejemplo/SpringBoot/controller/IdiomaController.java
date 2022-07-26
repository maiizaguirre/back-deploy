package com.ejemplo.SpringBoot.controller;

import com.ejemplo.SpringBoot.model.Idioma;
import com.ejemplo.SpringBoot.service.IIdiomaService;
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

public class IdiomaController {
    
@Autowired    
    private IIdiomaService idiomaServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/idioma")
    public void agregarIdioma (@RequestBody Idioma idioma) {
        idiomaServ.crearIdioma(idioma);
    }

    @GetMapping ("/ver/idioma")
    @ResponseBody
    public List<Idioma> verIdioma () {
       return idiomaServ.verIdioma();
    }      
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{idIdioma}")
    public void borrarIdioma (@PathVariable Long id) {
        idiomaServ.borrarIdioma(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/modificar/idioma/{id}")
    public Idioma modificarIdioma (@PathVariable Long id,
                                    @RequestParam ("idioma") String nuevoIdioma,
                                    @RequestParam ("nivel") String nuevoNivel,
                                    @RequestParam ("descripcion") String nuevoDescripcion) {      


       Idioma idioma =  idiomaServ.buscarIdioma(id);     

             
        idioma.setIdioma(nuevoIdioma);
        idioma.setNivel(nuevoNivel);
        idioma.setDescripcion(nuevoDescripcion);
        
        
        idiomaServ.crearIdioma(idioma);
       
        return idioma;
}

}