
package com.porfolio.alecarb.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TrabajoDto implements Serializable{
    
    private String empresa;
    private String image_trab;
    private String puesto;
    private String text_descrip;
    private String fecha_inicio;
    private String fecha_fin;
    private String url;
   
    
    public TrabajoDto(){
        
    }

    public TrabajoDto(String empresa, String image_trab, String puesto, String text_descrip, String fecha_inicio, String fecha_fin, String url) {
        this.empresa = empresa;
        this.image_trab = image_trab;
        this.puesto = puesto;
        this.text_descrip = text_descrip;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.url = url;
    }

   
    
}
