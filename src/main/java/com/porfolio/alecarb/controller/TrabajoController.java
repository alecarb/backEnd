
package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.TrabajoDto;
import com.porfolio.alecarb.entity.Trabajo;
import com.porfolio.alecarb.service.TrabajoService;
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
@RequestMapping("/trabajo")
@CrossOrigin(origins = "http://localhost:4200")
public class TrabajoController {
    
    @Autowired
    TrabajoService trabajoService;
    
    @GetMapping("/list")
    @ResponseBody
    public List<Trabajo> list(){
       return trabajoService.list();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<Trabajo>getOneByID(@PathVariable(value = "id") Long id){
        try {
            Trabajo trabajo = trabajoService.findById(id).get();
            return new ResponseEntity(trabajo,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/trabajo")
    public void save(@RequestBody Trabajo trabajo){
        trabajoService.save(trabajo);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> editTrabajo(@PathVariable Long id,@RequestBody TrabajoDto trabajoDto){
        try {
            Trabajo trabajo = trabajoService.findById(id).get();
            trabajo.setEmpresa(trabajoDto.getEmpresa());
            //trabajo.setImage_trab(trabajoDto.getImage_trab());
            trabajo.setPuesto(trabajoDto.getPuesto());
            trabajo.setFecha_inicio(trabajoDto.getFecha_inicio());
            trabajo.setFecha_fin(trabajoDto.getFecha_fin());
            trabajo.setText_descrip(trabajoDto.getText_descrip());
            
            trabajoService.save(trabajo);
            return new ResponseEntity<>(trabajo,HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<Trabajo>(HttpStatus.NOT_FOUND);
        }
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        trabajoService.deleteById(id);
    }
}
