
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.HardSkill;
import com.porfolio.alecarb.repository.IHardSkillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardSkillService {
    
    
    @Autowired
    private IHardSkillRepository hardSkillRepository;
    
    public List<HardSkill> listarHardSkill(){
        return hardSkillRepository.findAll();
    }
    
    public Optional<HardSkill> traerHardSkill_x_id(Long id){
        return hardSkillRepository.findById(id);
    }
    
    public void guardarHardSkill(HardSkill hardSkill){
        hardSkillRepository.save(hardSkill);
    }
    
    public void eliminarHardSkill(Long id){
        hardSkillRepository.deleteById(id);
    }
}
