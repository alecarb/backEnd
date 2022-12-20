
package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.EducacionDto;
import com.porfolio.alecarb.entity.Educacion;
import com.porfolio.alecarb.service.EducacionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class EducacionController {
    
    @Autowired 
    EducacionService educacionService;
    
    @GetMapping("/ver/educaciones")
    @ResponseBody
    public List<Educacion> list(){
        return educacionService.list();
    }
    
    @GetMapping("/educacion/{id}")
    @ResponseBody
    public Optional<Educacion> findById(Long id){
        return educacionService.findById(id);
    }
    
    @PostMapping("/new/educacion")
    public void save(@RequestBody Educacion nuevEducacion){
        educacionService.save(nuevEducacion);
    }
    
   
    @PutMapping("/edit/educacion/{id}")
    @ResponseBody
    public ResponseEntity<?> editEducacion(@PathVariable("id") Long id, EducacionDto educacionDto){
        try {
            Educacion educacion = educacionService.findById(id).get(); //buscamos la educacion
            educacion.setImage_est(educacionDto.getImage_est());
            educacion.setInstitucion(educacionDto.getInstitucion());
            educacion.setTitulo(educacionDto.getInstitucion());
            educacionDto.se
        } catch (Exception e) {
        }
    }
    
}
