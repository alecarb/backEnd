
package com.porfolio.alecarb.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Acerca_miDto implements Serializable{
    
    private String descripcion;
    
    
    public Acerca_miDto(){
        
    }

    public Acerca_miDto(String descripcion) {
        this.descripcion = descripcion;
      
    }
    
    
        
}
