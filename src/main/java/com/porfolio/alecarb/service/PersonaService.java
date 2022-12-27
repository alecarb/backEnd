
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.Persona;
import com.porfolio.alecarb.repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional  // método o bloque de código debe ejecutarse dentro de una transacción, 
//lo que significa que todas las operaciones realizadas dentro del método o bloque se considerarán 
//parte de una única transacción y se realizarán de manera atómica. 
//Esto es útil para garantizar la consistencia de los datos y evitar errores en operaciones 
//que involucren varias operaciones de base de datos. 
public class PersonaService {
    @Autowired
    IPersonaRepository personaRepository;
    
    public List<Persona> list(){
        return personaRepository.findAll();
    }
    
    public Optional<Persona> findById(Long id){
        return personaRepository.findById(id);
    }
    
    public void save(Persona persona){
        personaRepository.save(persona);
    }
    
    public void deleteById(Long id){
        personaRepository.deleteById(id);
    }
   
    
    
}
