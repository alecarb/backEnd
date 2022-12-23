package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.SoftSkillDto;
import com.porfolio.alecarb.entity.SoftSkill;
import com.porfolio.alecarb.service.SoftSkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "http://localhost:4200")
public class SoftSkillController {

    @Autowired
    SoftSkillService softSkillService;

    @GetMapping("/list")
    @ResponseBody
    public List<SoftSkill> list() {
        return softSkillService.list();

    }

    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<SoftSkill>getOneByID(@PathVariable(value = "id") Long id){
        try {
            SoftSkill softSkill = softSkillService.findById(id).get();
            return new ResponseEntity(softSkill,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/new/skill") //llevo a esa ruta
    public void save(@RequestBody SoftSkill nuevSkill) { //nombre del metodo y el request que le paso en Json desde Postman
        softSkillService.save(nuevSkill); //traigo el metodo del servicio
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        softSkillService.deleteById(id);
    }

    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody SoftSkillDto softSkillDto) {
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
