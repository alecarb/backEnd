
package com.porfolio.alecarb.repository;

import com.porfolio.alecarb.entity.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoftSkillRepository extends JpaRepository<SoftSkill, Integer>{
    
}
