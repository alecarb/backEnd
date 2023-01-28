package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.TrabajoDto;
import com.porfolio.alecarb.entity.Persona;
import com.porfolio.alecarb.entity.Trabajo;
import com.porfolio.alecarb.service.PersonaService;
import com.porfolio.alecarb.service.TrabajoService;
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
@RequestMapping("/trabajo")
@CrossOrigin(origins = "https://alecarbargprog.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class TrabajoController {

    @Autowired
    TrabajoService trabajoService;
    @Autowired
    PersonaService personaService;

    @GetMapping("/list")
    @ResponseBody
    public List<Trabajo> list() {
        return trabajoService.list();
    }



    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<?> getOneByID(@PathVariable int id) {
        try {
            Trabajo trabajo = trabajoService.findById(id).get();
            return new ResponseEntity(trabajo, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
       /*
    @GetMapping("/ver/{id}")
    @ResponseBody
    public ResponseEntity<?> getOneByID(@PathVariable int id) {
        Trabajo trabajo = trabajoService.findById(id).orElseThrow(NoSuchElementException::new);
        return new ResponseEntity(trabajo, HttpStatus.OK);
    }
  */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/trabajo/{id}")
    @ResponseBody
    public ResponseEntity<?> addTrabajo(@PathVariable int id, @RequestBody Trabajo trabajo) {
        try {
            Persona persona = personaService.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Persona no encontrada con el id: " + id));
            trabajo.setPersona(persona);
            trabajoService.save(trabajo);
            return new ResponseEntity(trabajo, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(trabajo, HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> editTrabajo(@PathVariable int id, @RequestBody TrabajoDto trabajoDto) {
        try {
            Trabajo trabajo = trabajoService.findById(id).get();
            trabajo.setEmpresa(trabajoDto.getEmpresa());
            //trabajo.setImage_trab(trabajoDto.getImage_trab());
            trabajo.setPuesto(trabajoDto.getPuesto());
            trabajo.setFecha_inicio(trabajoDto.getFecha_inicio());
            trabajo.setFecha_fin(trabajoDto.getFecha_fin());
            trabajo.setText_descrip(trabajoDto.getText_descrip());

            trabajoService.save(trabajo);
            return new ResponseEntity<>(trabajo, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Trabajo>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        try {
            Trabajo trabajo = trabajoService.findById(id) //se busca el trabajo que se paso por parametro
                    .orElseThrow(() -> new NoSuchElementException("Trabajo no encontrado con el id: " + id));
            Persona persona = trabajo.getPersona(); //se trae la perona que tiene la relacion con ese trabajo
            persona.getTrabajos().remove(trabajo); //se trae la lista de los trabajos y se elimina la relacion para no violar el restricción de integridad referencial (foreign key constraint) que impide eliminar el objeto trabajo sin primero eliminar la relación con la entidad persona.
            trabajoService.deleteById(id); //se llama al servcio y se elimina el objeto (el trabajo)
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
