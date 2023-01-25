
package com.porfolio.alecarb.repository;

import com.porfolio.alecarb.entity.HardSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHardSkillRepository extends JpaRepository<HardSkill, Integer>{
    
}
