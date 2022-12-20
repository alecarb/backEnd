
package com.porfolio.alecarb.repository;

import com.porfolio.alecarb.entity.Acerca_mi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcerca_miRepository extends JpaRepository<Acerca_mi, Long>{
    
}
