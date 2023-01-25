
package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.EducacionDto;
import com.porfolio.alecarb.entity.Educacion;
import com.porfolio.alecarb.entity.Persona;
import com.porfolio.alecarb.service.EducacionService;
import com.porfolio.alecarb.service.PersonaService;
import java.util.List;
import java.util.NoSuchElementException;
import org.hibernate.resource.beans.container.internal.NoSuchBeanException;
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
@RequestMapping("/educacion")
@CrossOrigin (origins = "https://alecarbargprog.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    @Autowired 
    EducacionService educacionService;
    @Autowired
    PersonaService personaService;
    
    @GetMapping("/list")
    @ResponseBody
    public List<Educacion> list(){
        return educacionService.list();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<?> getOneByID(@PathVariable int id) {
        try {
            Educacion educacion = educacionService.findById(id).get();
            return new ResponseEntity(educacion, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/educacion/{id}")
    @ResponseBody
    public ResponseEntity<?> addEduc(@PathVariable int id,@RequestBody Educacion educacion){
        try {
            Persona persona = personaService.findById(id)
                    .orElseThrow(()-> new NoSuchElementException("Persona no encontrada id: " + id));
            educacion.setPersona(persona);
            educacionService.save(educacion);
            return new ResponseEntity(educacion, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(educacion, HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> editEducacion(@PathVariable("id") int id,@RequestBody EducacionDto educacionDto){
        try {
            Educacion educacion = educacionService.findById(id).get(); //buscamos la educacion
            //educacion.setImage_est(educacionDto.getImage_est());
            educacion.setInstitucion(educacionDto.getInstitucion());
            educacion.setTitulo(educacionDto.getTitulo());
            educacion.setFecha_inicio(educacionDto.getFecha_inicio());
            educacion.setFecha_fin(educacionDto.getFecha_fin());
            //educacion.setEn_curso(educacionDto.isEn_curso());
            
            educacionService.save(educacion);
            return new ResponseEntity<>(educacion,HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<Educacion>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteEduc(@PathVariable int id){
        try {
            Educacion educacion = educacionService.findById(id)
                    .orElseThrow(()-> new NoSuchElementException("No se encuatra el objeto educacion con el id: " + id));
            Persona persona = educacion.getPersona();
            persona.getEducaciones().remove(educacion);
            educacionService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
