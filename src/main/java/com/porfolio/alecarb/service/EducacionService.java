
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.Educacion;
import com.porfolio.alecarb.repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService {
    
    @Autowired
    private IEducacionRepository educacionRepository;
    
    public List<Educacion> list(){
        return educacionRepository.findAll();
    }
    
    public Optional<Educacion> findById(Long id){
        return educacionRepository.findById(id);
    }
    
    public void save(Educacion educacion){
        educacionRepository.save(educacion);
    }
    
    public void deleteById(Long id){
        educacionRepository.deleteById(id);
    }
    
}
