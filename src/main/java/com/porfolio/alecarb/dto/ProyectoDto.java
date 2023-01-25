
package com.porfolio.alecarb.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class ProyectoDto implements Serializable{
    
    private String proyecto;
    private String descripcion;
    private String image_proy;
    public ProyectoDto(){
        
    }

    public ProyectoDto(String proyecto, String descripcion, String image_proy) {
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.image_proy = image_proy;
    }
    
    
    
}
