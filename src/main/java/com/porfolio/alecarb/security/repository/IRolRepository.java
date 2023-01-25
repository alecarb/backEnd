
package com.porfolio.alecarb.security.repository;

import com.porfolio.alecarb.security.entity.Rol;
import com.porfolio.alecarb.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
