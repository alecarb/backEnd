
package com.porfolio.alecarb.security.entity;

import com.porfolio.alecarb.security.enums.RolNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    //se indica que va a ser un Enum de tipo String
    @Enumerated(EnumType.STRING) 
    @NotNull
    private RolNombre rolNombre;
    
    public Rol(){
        
    }
    
    public Rol(@NotNull RolNombre rolNombre){
        this.rolNombre = rolNombre;
    }
    
}
