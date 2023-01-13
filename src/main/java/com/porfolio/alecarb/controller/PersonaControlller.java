package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.PersonaDto;
import com.porfolio.alecarb.entity.Persona;
import com.porfolio.alecarb.service.PersonaService;
import java.util.List;
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
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaControlller {

   
    @Autowired
    PersonaService personaService;

    @GetMapping("/ver/persona") //trae en esa ruta
    @ResponseBody //la respuesta del cuerpo
    public List<Persona> verPersonas() { //creo el metodo del controlador
        return personaService.list(); //aca llamo al metodo del servicio
    }
   
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<Persona>getOneByID(@PathVariable(value = "id") Long id){
        try {
            Persona persona = personaService.findById(id).get();
            return new ResponseEntity(persona,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


   // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/persona") //llevo a esa ruta
    public void save(@RequestBody Persona nuevPersona) { //nombre del metodo y el request que le paso en Json desde Postman
        personaService.save(nuevPersona); //traigo el metodo del servicio
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deletePersonaByid(@PathVariable Long id) {
        personaService.deleteById(id);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> editPersona(@PathVariable Long id, @RequestBody PersonaDto personaDto) {
        try {
            Persona persona = personaService.findById(id).get(); //buscamos el usuario 
            persona.setNombre(personaDto.getNombre()); //traemos el nombre desde el DTO y lo seteo
            persona.setApellido(personaDto.getApellido()); //traigo el apellodo del DTO Y lo seteo
            persona.setEmail(personaDto.getEmail());
            persona.setResidencia(personaDto.getResidencia());
            persona.setDni(personaDto.getDni());
            persona.setTelefono(personaDto.getTelefono());

            personaService.save(persona); //guardamos los cambios.
            return new ResponseEntity<>(persona, HttpStatus.OK); // se retorna una respuesta con status 200

        } catch (Exception e) {
            System.out.println("Error updating user: " + e);

            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND); //se retorna una respuesta 404

        }
    }
}
