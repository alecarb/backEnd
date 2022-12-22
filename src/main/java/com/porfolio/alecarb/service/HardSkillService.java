
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.HardSkill;
import com.porfolio.alecarb.repository.IHardSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HardSkillService {
    
    
    @Autowired
    IHardSkillRepository hardSkillRepository;
    
    public List<HardSkill> list(){
        return hardSkillRepository.findAll();
    }
    
    public Optional<HardSkill> findByid(Long id){
        return hardSkillRepository.findById(id);
    }
    
    public void save(HardSkill hardSkill){
        hardSkillRepository.save(hardSkill);
    }
    
    public void deleteById(Long id){
        hardSkillRepository.deleteById(id);
    }
}
