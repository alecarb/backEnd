
package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.HardSkillDto;
import com.porfolio.alecarb.entity.HardSkill;
import com.porfolio.alecarb.service.HardSkillService;
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
@RequestMapping("/hardSkill")
@CrossOrigin(origins = "http://localhost:4200")
public class HardSkillController {
    @Autowired
    HardSkillService hardSkillService;
    
    @GetMapping("/list")
    @ResponseBody
    public List<HardSkill> list() {
        return hardSkillService.list();

    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<HardSkill>getOneByID(@PathVariable(value = "id") Long id){
        try {
            HardSkill hardSkill = hardSkillService.findByid(id).get();
            return new ResponseEntity(hardSkill,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/skill") //llevo a esa ruta
    public void save(@RequestBody HardSkill nuevSkill) { //nombre del metodo y el request que le paso en Json desde Postman
        hardSkillService.save(nuevSkill); //traigo el metodo del servicio
    }
    
  //  @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody HardSkillDto hardSkillDto) {
        try {
            HardSkill softSkill = hardSkillService.findByid(id).get();
            softSkill.setHabilidad(hardSkillDto.getHabilidad());
            softSkill.setPorcentaje(hardSkillDto.getPorcentaje());
            
            hardSkillService.save(softSkill);
            return new ResponseEntity<>(softSkill, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error updating user: " + e);
            return new ResponseEntity<HardSkill>(HttpStatus.NOT_FOUND);
        }

    }
    
  //  @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        hardSkillService.deleteById(id);
    }
    
    
}
