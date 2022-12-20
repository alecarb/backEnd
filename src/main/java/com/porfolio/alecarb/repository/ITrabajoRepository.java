
package com.porfolio.alecarb.repository;

import com.porfolio.alecarb.entity.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajoRepository extends JpaRepository<Trabajo, Long> {
    
}
