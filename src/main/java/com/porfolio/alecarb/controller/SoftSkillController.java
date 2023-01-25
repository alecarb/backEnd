package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.SoftSkillDto;
import com.porfolio.alecarb.entity.Persona;
import com.porfolio.alecarb.entity.SoftSkill;
import com.porfolio.alecarb.service.PersonaService;
import com.porfolio.alecarb.service.SoftSkillService;
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
@RequestMapping("/softSkill")
@CrossOrigin (origins = "https://alecarbargprog.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class SoftSkillController {

    @Autowired
    SoftSkillService softSkillService;
    @Autowired
    PersonaService personaService;

    @GetMapping("/list")
    @ResponseBody
    public List<SoftSkill> list() {
        return softSkillService.list();

    }

    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<SoftSkill>getOneByID(@PathVariable(value = "id") int id){
        try {
            SoftSkill softSkill = softSkillService.findById(id).get();
            return new ResponseEntity(softSkill,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/skill/{id}") 
    @ResponseBody
    public ResponseEntity<?>addSkill(@PathVariable int id, @RequestBody SoftSkill softSkill){
        try {
            Persona persona = personaService.findById(id).orElseThrow(() -> new NoSuchElementException("Persona no encontrada con el id: " + id));
        softSkill.setPersona(persona);
        softSkillService.save(softSkill);
        return  new ResponseEntity<>(softSkill, HttpStatus.OK);
        } catch (Exception e) {
             System.out.println("Error: " + e);
            return new ResponseEntity<SoftSkill>(HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            SoftSkill softSkill = softSkillService.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Soft Skill no encontrado, id: "+ id));
            Persona persona = softSkill.getPersona();
            persona.getSoftSkills().remove(softSkill);
            softSkillService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);      
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        
    }
           
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> edit(@PathVariable int id, @RequestBody SoftSkillDto softSkillDto) {
        try {
            SoftSkill softSkill = softSkillService.findById(id).get();
            softSkill.setHabilidad(softSkillDto.getHabilidad());
            softSkill.setPorcentaje(softSkillDto.getPorcentaje());
            
            softSkillService.save(softSkill);
            return new ResponseEntity<>(softSkill, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error updating user: " + e);
            return new ResponseEntity<SoftSkill>(HttpStatus.NOT_FOUND);
        }

    }

}
