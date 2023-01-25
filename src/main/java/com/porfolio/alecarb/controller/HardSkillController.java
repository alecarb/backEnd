package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.HardSkillDto;
import com.porfolio.alecarb.entity.HardSkill;
import com.porfolio.alecarb.entity.Persona;
import com.porfolio.alecarb.service.HardSkillService;
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
@RequestMapping("/hardSkill")
@CrossOrigin(origins = "https://alecarbargprog.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class HardSkillController {

    @Autowired
    HardSkillService hardSkillService;
    @Autowired
    PersonaService personaService;

    @GetMapping("/list")
    @ResponseBody
    public List<HardSkill> list() {
        return hardSkillService.list();

    }

    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<HardSkill> getOneByID(@PathVariable int id) {
        try {
            HardSkill hardSkill = hardSkillService.findByid(id).get();
            return new ResponseEntity(hardSkill, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/skill/{id}") //llevo a esa ruta
    @ResponseBody
    public ResponseEntity<?> addHskill(@PathVariable int id, @RequestBody HardSkill hardSkill) {
        try {
            Persona persona = personaService.findById(id)
                    .orElseThrow(()-> new NoSuchElementException("Persona no encontrada, id: " + id));
            hardSkill.setPersona(persona);
            hardSkillService.save(hardSkill);
            return new ResponseEntity<>(hardSkill, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(hardSkill, HttpStatus.NOT_FOUND);

        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody HardSkillDto hardSkillDto) {
        try {
            HardSkill hardSkill = hardSkillService.findByid(id).get();
            hardSkill.setHabilidad(hardSkillDto.getHabilidad());
            hardSkill.setPorcentaje(hardSkillDto.getPorcentaje());

            hardSkillService.save(hardSkill);
            return new ResponseEntity<>(hardSkill, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error updating user: " + e);
            return new ResponseEntity<HardSkill>(HttpStatus.NOT_FOUND);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteHardSkill(@PathVariable int id) {
        try {
            HardSkill hardSkill = hardSkillService.findByid(id)
                    .orElseThrow(() -> new NoSuchElementException("No se encuentra el objeto hardSkill con id: " + id));
            Persona persona = hardSkill.getPersona();
            persona.getHardSkills().remove(hardSkill);
            hardSkillService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
