
package com.porfolio.alecarb.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducacionDto implements Serializable{
    

   
    
    private String institucion;
   
    private String titulo;
    
    private String fecha_inicio;
    
    private String fecha_fin;
  
    
    
    private EducacionDto(){
        
    }

    public EducacionDto(String institucion, String titulo, String fecha_inicio, String fecha_fin) {
        
       
        this.institucion = institucion;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        
    }
    
    
    
}
