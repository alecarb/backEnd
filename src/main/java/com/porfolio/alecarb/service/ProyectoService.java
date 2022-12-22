
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.Proyecto;
import com.porfolio.alecarb.repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    IProyectoRepository proyectoRepository;
    
    public List<Proyecto> list(){
        return proyectoRepository.findAll();
    }
    
    public Optional<Proyecto> findById(Long id){
        return proyectoRepository.findById(id);
    }
    
    public void save(Proyecto proyecto){
        proyectoRepository.save(proyecto);
    }
    
    public void deleteById(Long id){
        proyectoRepository.deleteById(id);
    }
    
}
