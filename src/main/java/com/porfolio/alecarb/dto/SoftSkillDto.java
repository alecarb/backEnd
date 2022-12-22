
package com.porfolio.alecarb.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SoftSkillDto implements Serializable{

    private String habilidad;
    private int porcentaje;
    
    public SoftSkillDto(){
        
    }

    public SoftSkillDto(String habilidad, int porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }
    
    
}
