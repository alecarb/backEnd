
package com.porfolio.alecarb.security.entity;

import com.porfolio.alecarb.security.enums.RolNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//NO IMPORTA javax.validatios !!!

@Entity
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
 
    @Enumerated(EnumType.STRING) //poner el @NotNull solucionar eso
    private RolNombre rolNombre;
    
}
