
package com.porfolio.alecarb.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Acerca_miDto implements Serializable{
    
    private String descripcion;
    private String img_perfil;
    
    public Acerca_miDto(){
        
    }

    public Acerca_miDto(String descripcion, String img_perfil) {
        this.descripcion = descripcion;
        this.img_perfil = img_perfil;
    }
    
    
        
}
