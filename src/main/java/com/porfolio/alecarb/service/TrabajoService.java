
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.Trabajo;
import com.porfolio.alecarb.repository.ITrabajoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrabajoService {
    
    @Autowired
    private ITrabajoRepository trabajoRepository;
    
    public List<Trabajo> listar_trabajos(){
        return trabajoRepository.findAll();
    }
    
    public Optional<Trabajo> traerTrabajo_x_id(Long id){
        return trabajoRepository.findById(id);
    }
    
    public Trabajo guardarTrabajo(Trabajo trabajo){
        return trabajoRepository.save(trabajo);
    }
    
    public void eliminar_trabajo_x_id(Long id){
        trabajoRepository.deleteById(id);
    }
}
