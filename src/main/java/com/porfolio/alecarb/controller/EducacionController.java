
package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.EducacionDto;
import com.porfolio.alecarb.entity.Educacion;
import com.porfolio.alecarb.service.EducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    @Autowired 
    EducacionService educacionService;
    
    @GetMapping("/list")
    @ResponseBody
    public List<Educacion> list(){
        return educacionService.list();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<Educacion>getOneByID(@PathVariable(value = "id") Long id){
        try {
            Educacion educacion = educacionService.findById(id).get();
            return new ResponseEntity(educacion,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/educacion")
    public void save(@RequestBody Educacion educacion){
        educacionService.save(educacion);
    }
    
//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> editEducacion(@PathVariable("id") Long id,@RequestBody EducacionDto educacionDto){
        try {
            Educacion educacion = educacionService.findById(id).get(); //buscamos la educacion
            //educacion.setImage_est(educacionDto.getImage_est());
            educacion.setInstitucion(educacionDto.getInstitucion());
            educacion.setTitulo(educacionDto.getTitulo());
            educacion.setFecha_inicio(educacionDto.getFecha_inicio());
            educacion.setFecha_fin(educacionDto.getFecha_fin());
            educacion.setEn_curso(educacionDto.isEn_curso());
            
            educacionService.save(educacion);
            return new ResponseEntity<>(educacion,HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<Educacion>(HttpStatus.NOT_FOUND);
        }
    }
    
 //   @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        educacionService.deleteById(id);
    }
    
}
