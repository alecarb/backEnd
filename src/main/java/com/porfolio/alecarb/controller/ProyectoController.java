
package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.ProyectoDto;
import com.porfolio.alecarb.entity.Persona;
import com.porfolio.alecarb.entity.Proyecto;
import com.porfolio.alecarb.service.PersonaService;
import com.porfolio.alecarb.service.ProyectoService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/proyecto")
@CrossOrigin (origins = "https://alecarbargprog.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    
    @Autowired
    ProyectoService proyectoService;
    @Autowired
    PersonaService personaService;
    
    @GetMapping("/list") //trae en esa ruta
    @ResponseBody //la respuesta del cuerpo
    public List<Proyecto> verproyectos() { //creo el metodo del controlador
        return proyectoService.list(); //aca llamo al metodo del servicio
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<Proyecto>getOneByID(@PathVariable(value = "id") int id){
        try {
            Proyecto proyecto = proyectoService.findById(id).get();
            return new ResponseEntity(proyecto,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/proyecto/{id}")
    @ResponseBody
    public ResponseEntity<?> addProyecto(@PathVariable int id, @RequestBody Proyecto proyecto){
        try{
            Persona persona = personaService.findById(id).orElseThrow(() -> new NoSuchElementException("Persona no encontrada con el id: " + id));
            proyecto.setPersona(persona);
            proyectoService.save(proyecto);
            return new ResponseEntity(proyecto, HttpStatus.OK);                        
        }catch (Exception e){
            System.out.println("Error: "+ e);
            return new ResponseEntity(proyecto, HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> edit(@PathVariable int id, @RequestBody ProyectoDto proyectoDto){
        try {
            Proyecto proyecto = proyectoService.findById(id).get();
            proyecto.setProyecto(proyectoDto.getProyecto());
            proyecto.setDescripcion(proyectoDto.getProyecto());
            proyecto.setImage_proy(proyectoDto.getImage_proy());
            proyectoService.save(proyecto);
            return new ResponseEntity<>(proyecto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Proyecto>(HttpStatus.NOT_FOUND);
        }        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteProy(@PathVariable int id){
        try {
            Proyecto proyecto = proyectoService.findById(id)
                    .orElseThrow(()-> new NoSuchElementException("No se encuentra el proyecto, id: "+ id));
                    Persona persona = proyecto.getPersona();
                    persona.getProyectos().remove(proyecto);
                    proyectoService.deleteById(id);
                    return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
}

