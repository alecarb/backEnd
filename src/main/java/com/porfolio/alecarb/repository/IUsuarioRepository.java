
package com.porfolio.alecarb.repository;

import com.porfolio.alecarb.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository  extends JpaRepository<Usuario, Long>{
    
}
