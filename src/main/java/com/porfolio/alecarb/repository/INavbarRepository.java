
package com.porfolio.alecarb.repository;

import com.porfolio.alecarb.entity.Navbar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INavbarRepository extends JpaRepository<Navbar, Long>{
    
}
