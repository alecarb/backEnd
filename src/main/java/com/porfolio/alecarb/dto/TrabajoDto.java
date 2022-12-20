
package com.porfolio.alecarb.dto;


public class TrabajoDto {
    
    private String image_trab;
    private String puesto;
    private String text_descrip;
    private String fecha_inicio;
    private String fecha_fin;
    private boolean es_actual;
    
    public TrabajoDto(){
        
    }

    public TrabajoDto(String image_trab, String puesto, String text_descrip, String fecha_inicio, String fecha_fin, boolean es_actual) {
        this.image_trab = image_trab;
        this.puesto = puesto;
        this.text_descrip = text_descrip;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.es_actual = es_actual;
    }
    
    
}
