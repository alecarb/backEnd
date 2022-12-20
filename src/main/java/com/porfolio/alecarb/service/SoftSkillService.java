
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.SoftSkill;
import com.porfolio.alecarb.repository.ISoftSkillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftSkillService {
    
    @Autowired
    private ISoftSkillRepository softSkillRepository;
    
    public List<SoftSkill> listarSoftSkills(){
        return softSkillRepository.findAll();
    }
    
    public Optional<SoftSkill> traerSoftSkill_x_id(Long id){
        return softSkillRepository.findById(id);
    }
    
    public void guardarSoftSkill(SoftSkill softSkill ){
        softSkillRepository.save(softSkill);
    }
    
    public void eliminarSofSkill_x_id(Long id){
        softSkillRepository.deleteById(id);
    }
}
