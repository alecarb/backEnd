
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.Educacion;
import com.porfolio.alecarb.repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    
    @Autowired
    IEducacionRepository educacionRepository;
    
    public List<Educacion> list(){
        return educacionRepository.findAll();
    }
    
    public Optional<Educacion> findById(int id){
        return educacionRepository.findById(id);
    }
    
    public void save(Educacion educacion){
        educacionRepository.save(educacion);
    }
    
    public void deleteById(int id){
        educacionRepository.deleteById(id);
    }
    
}
