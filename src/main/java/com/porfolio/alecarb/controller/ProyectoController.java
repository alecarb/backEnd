
package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.ProyectoDto;
import com.porfolio.alecarb.entity.Proyecto;
import com.porfolio.alecarb.service.ProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    
    @Autowired
    ProyectoService proyectoService;
    
    @GetMapping("/ver/proyectos") //trae en esa ruta
    @ResponseBody //la respuesta del cuerpo
    public List<Proyecto> verproyectos() { //creo el metodo del controlador
        return proyectoService.list(); //aca llamo al metodo del servicio
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<Proyecto>getOneByID(@PathVariable(value = "id") Long id){
        try {
            Proyecto proyecto = proyectoService.findById(id).get();
            return new ResponseEntity(proyecto,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/new/proyecto")
    public void save(@RequestBody Proyecto proyecto){
        proyectoService.save(proyecto);
    }
    
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody ProyectoDto proyectoDto){
        try {
            Proyecto proyecto = proyectoService.findById(id).get();
            proyecto.setProyecto(proyectoDto.getProyecto());
            
            proyectoService.save(proyecto);
            return new ResponseEntity<>(proyecto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Proyecto>(HttpStatus.NOT_FOUND);
        }        
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        proyectoService.deleteById(id);
    }
    
}

