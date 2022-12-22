
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.Trabajo;
import com.porfolio.alecarb.repository.ITrabajoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TrabajoService {
    
    @Autowired
    ITrabajoRepository trabajoRepository;
    
    public List<Trabajo> list(){
        return trabajoRepository.findAll();
    }
    
    public Optional<Trabajo> findById(Long id){
        return trabajoRepository.findById(id);
    }
    
    public Trabajo save(Trabajo trabajo){
        return trabajoRepository.save(trabajo);
    }
    
    public void deleteById(Long id){
        trabajoRepository.deleteById(id);
    }
}
