package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.Acerca_miDto;
import com.porfolio.alecarb.entity.Acerca_mi;
import com.porfolio.alecarb.entity.Persona;
import com.porfolio.alecarb.service.Acerca_miService;
import com.porfolio.alecarb.service.PersonaService;
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
@RequestMapping("/about")
@CrossOrigin(origins = "https://alecarbargprog.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class Acerca_miController {

    @Autowired
    Acerca_miService acerca_miService;
    @Autowired
    PersonaService personaService;

    @GetMapping("/list")
    @ResponseBody
    public List<Acerca_mi> verLista() {
        return acerca_miService.list();
    }

    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<?> getOneByID(@PathVariable int id) {
        System.out.println("Valor de id antes de llamar al método: " + id);
        try {
            Acerca_mi acerca_mi = acerca_miService.fndById(id).get();
            return new ResponseEntity(acerca_mi, HttpStatus.OK);
           
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/about/{id}")
    @ResponseBody
    public ResponseEntity<?> addAbout(@PathVariable int id, @RequestBody Acerca_mi acerca_mi) {
        try {
            Persona persona = personaService.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Persona no encontrada id: " + id));
            acerca_mi.setPersona(persona);
            acerca_miService.save(acerca_mi);
            return new ResponseEntity(acerca_mi, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(acerca_mi, HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> editAbout(@PathVariable int id, @RequestBody Acerca_miDto acerca_miDto) {
        try {
            Acerca_mi acerca_mi = acerca_miService.fndById(id).get();

            acerca_mi.setDescripcion(acerca_miDto.getDescripcion());

            acerca_miService.save(acerca_mi); //guardo
            return new ResponseEntity<>(acerca_mi, HttpStatus.OK); //respuesta http
        } catch (Exception e) {
            return new ResponseEntity<Acerca_mi>(HttpStatus.NOT_FOUND); //No se guarda nada
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteAbout(@PathVariable int id) {
        try {
            Acerca_mi acerca_mi = acerca_miService.fndById(id)
                    .orElseThrow(() -> new NoSuchElementException("No se encuentra abaut con el id: " + id));
            Persona persona = acerca_mi.getPersona();
            persona.getAcerca_mis().remove(acerca_mi);
            acerca_miService.deleteByid(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
