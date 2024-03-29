
package com.porfolio.alecarb.repository;

import com.porfolio.alecarb.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository  extends JpaRepository<Persona, Integer>{
    
}
