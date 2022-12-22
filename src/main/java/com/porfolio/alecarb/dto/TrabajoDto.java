
package com.porfolio.alecarb.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TrabajoDto implements Serializable{
    
    private String image_trab;
    private String puesto;
    private String text_descrip;
    private String fecha_inicio;
    private String fecha_fin;
   
    
    public TrabajoDto(){
        
    }

    public TrabajoDto(String image_trab, String puesto, String text_descrip, String fecha_inicio, String fecha_fin) {
        this.image_trab = image_trab;
        this.puesto = puesto;
        this.text_descrip = text_descrip;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

   
    
}
