
package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.Acerca_miDto;
import com.porfolio.alecarb.entity.Acerca_mi;
import com.porfolio.alecarb.service.Acerca_miService;
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
@RequestMapping("/about")
@CrossOrigin(origins = "http://localhost:4200")
public class Acerca_miController {
    
    @Autowired
    Acerca_miService acerca_miService;
    
    @GetMapping("/list")
    @ResponseBody
    public List<Acerca_mi> verLista(){
        return acerca_miService.list();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<Acerca_mi>getOneByID(@PathVariable(value = "id") Long id){
        try {
            Acerca_mi acerca_mi = acerca_miService.fndById(id).get();
            return new ResponseEntity(acerca_mi,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/about")
    public void save(@RequestBody Acerca_mi acerca_mi){
        acerca_miService.save(acerca_mi);        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> editAbout (@PathVariable Long id, @RequestBody Acerca_miDto acerca_miDto){
        try {
            Acerca_mi acerca_mi = acerca_miService.fndById(id).get();
            acerca_mi.setImage_perfil(acerca_miDto.getImg_perfil());
            acerca_mi.setDescripcion(acerca_miDto.getDescripcion());
            
            acerca_miService.save(acerca_mi); //guardo
            return new ResponseEntity<>(acerca_mi,HttpStatus.OK); //respuesta http
        } catch (Exception e) {
            return new ResponseEntity<Acerca_mi>(HttpStatus.NOT_FOUND); //No se guarda nada
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        acerca_miService.deleteByid(id);
    }
    
    
    
}
