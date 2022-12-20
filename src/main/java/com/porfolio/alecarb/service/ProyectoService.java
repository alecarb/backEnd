
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.Proyecto;
import com.porfolio.alecarb.repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService {
    @Autowired
    private IProyectoRepository proyectoRepository;
    
    public List<Proyecto> listarProyectos(){
        return proyectoRepository.findAll();
    }
    
    public Optional<Proyecto> traerProyecto_x_id(Long id){
        return proyectoRepository.findById(id);
    }
    
    public void guardarProyecto(Proyecto proyecto){
        proyectoRepository.save(proyecto);
    }
    
    public void eliminarProyecto_x_id(Long id){
        proyectoRepository.deleteById(id);
    }
    
}
