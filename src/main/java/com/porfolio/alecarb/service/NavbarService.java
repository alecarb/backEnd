
package com.porfolio.alecarb.service;


import com.porfolio.alecarb.entity.Navbar;
import com.porfolio.alecarb.repository.INavbarRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NavbarService {
    
    @Autowired
    INavbarRepository navbarRepository;
    
    public List<Navbar> list(){
        return navbarRepository.findAll();
    }
    
    public Optional<Navbar> findById(int id){
        return navbarRepository.findById(id);
    }
    
    public void save(Navbar navbar){
        navbarRepository.save(navbar);
    }
        
    public void deleteById(int id){
        navbarRepository.deleteById(id);
    }
}
