
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.Acerca_mi;
import com.porfolio.alecarb.repository.IAcerca_miRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Acerca_miService {
    
    @Autowired
    IAcerca_miRepository acerca_miRepository;
    
    public List<Acerca_mi> list(){
       return acerca_miRepository.findAll();
    }
   
    public Optional<Acerca_mi> fndById(Long id){
        return acerca_miRepository.findById(id);
    }
    
    public void save (Acerca_mi acerca_mi){
        acerca_miRepository.save(acerca_mi);
    }
     
    public void deleteEntity (Acerca_mi acerca_mi){
        acerca_miRepository.delete(acerca_mi);
    }
    
    public void deleteByid(Long id){
        acerca_miRepository.deleteById(id);
    }
    
}
