
package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.NavbarDto;
import com.porfolio.alecarb.entity.Navbar;
import com.porfolio.alecarb.entity.Persona;
import com.porfolio.alecarb.service.NavbarService;
import com.porfolio.alecarb.service.PersonaService;
import java.util.List;
import java.util.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/navbar")
@CrossOrigin (origins = "https://alecarbargprog.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class NavbarController {
    
     //instancia del logger 
   //Logger log = LoggerFactory.getLogger(NavbarController.class);
    
    @Autowired
    NavbarService navbarService;
    @Autowired 
    PersonaService personaService;

    
    
    @GetMapping("/list")
    @ResponseBody
    public List<Navbar> list() {
        return navbarService.list();

    }

    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<Navbar>getOneByID(@PathVariable int id){
        try {
            Navbar navbar = navbarService.findById(id).get();
            return new ResponseEntity(navbar,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/navbar/{id}") //llevo a esa ruta
    @ResponseBody
    public ResponseEntity<Navbar>addNavBar(@PathVariable int id, @RequestBody Navbar navbar){
        try {
            Persona persona = personaService.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Persona no encontrada con el id: " + id));
            navbar.setPersona(persona);
            navbarService.save(navbar);
            return new ResponseEntity(navbar, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: "+ e);
            return  new ResponseEntity(navbar, HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteNav(@PathVariable int id){
        try {
            Navbar navbar = navbarService.findById(id)
                    .orElseThrow(()-> new NoSuchElementException("No se encuentra el objeto con el id: "+ id));
            Persona persona = navbar.getPersona();
            persona.getNavbars().remove(navbar);
            navbarService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: "+ e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody NavbarDto navbarDto) {
        //log.info("El id recibido es: " + navbarDto.getId());

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
