
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.SoftSkill;
import com.porfolio.alecarb.repository.ISoftSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SoftSkillService {
    
    @Autowired
    ISoftSkillRepository softSkillRepository;
    
    public List<SoftSkill> list(){
        return softSkillRepository.findAll();
    }
    
    public Optional<SoftSkill> findById(int id){
        return softSkillRepository.findById(id);
    }
    
    public void save(SoftSkill softSkill ){
        softSkillRepository.save(softSkill);
    }
    
    public void deleteById(int id){
        softSkillRepository.deleteById(id);
    }
}
