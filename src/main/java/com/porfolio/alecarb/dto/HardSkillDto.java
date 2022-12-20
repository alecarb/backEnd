
package com.porfolio.alecarb.dto;

import java.io.Serializable;


public class HardSkillDto implements Serializable{
    
    private String habilidad;
    private int porcentaje;
    
    public HardSkillDto(){
        
    }

    public HardSkillDto(String habilidad, int porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }
    
    
}
