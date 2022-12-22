
package com.porfolio.alecarb.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class ProyectoDto implements Serializable{
    
    private String proyecto;
    
    public ProyectoDto(){
        
    }

    public ProyectoDto(String proyecto) {
        this.proyecto = proyecto;
    }
    
    
    
}
