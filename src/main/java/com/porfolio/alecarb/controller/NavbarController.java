
package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.NavbarDto;
import com.porfolio.alecarb.entity.Navbar;
import com.porfolio.alecarb.entity.SoftSkill;
import com.porfolio.alecarb.service.NavbarService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/navbar")
@CrossOrigin(origins = "http://localhost:4200")
public class NavbarController {
    
     //instancia del logger 
   Logger log = LoggerFactory.getLogger(NavbarController.class);


    
    
    
    @Autowired
    NavbarService navbarService;

    @GetMapping("/list")
    @ResponseBody
    public List<Navbar> list() {
        return navbarService.list();

    }

    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<SoftSkill>getOneByID(@PathVariable(value = "id") Long id){
        try {
            Navbar navbar = navbarService.findById(id).get();
            return new ResponseEntity(navbar,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/navbar") //llevo a esa ruta
    public void save(@RequestBody Navbar nuevo) { //nombre del metodo y el request que le paso en Json desde Postman
        navbarService.save(nuevo); //traigo el metodo del servicio
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        navbarService.deleteById(id);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody NavbarDto navbarDto) {
        log.info("El id recibido es: " + navbarDto.getId());

        try {
            Navbar navbar = navbarService.findById(id).get();
            navbar.setRed(navbarDto.getRed());
            navbar.setLogo(navbarDto.getLogo());
            navbar.setNombre(navbarDto.getNombre());
            return new ResponseEntity<>(navbarDto, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error updating user: " + e);
            return new ResponseEntity<Navbar>(HttpStatus.NOT_FOUND);
        }

    }


    
    
    
    
    
    
}
