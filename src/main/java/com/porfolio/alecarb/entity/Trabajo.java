
package com.porfolio.alecarb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter @Setter
public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "empresa")
    private  String empresa;
    //@Column(name = "image_trab")
    //private String image_trab;
    @Column(name = "puesto")
    private String puesto;
    @Column(name = "text_descrip")
    private String text_descrip;
    @Column (name = "fecha_inicio")
    private String fecha_inicio;
    @Column(name = "fecha_fin")
    private String fecha_fin;
    @Column(name = "url")
    private String url;
  
    
    public Trabajo() {
    }

    public Trabajo(Long id,String empresa , String puesto, String text_descrip, String fecha_inicio, String fecha_fin, String url, Persona persona) {
        this.id = id;
        this.empresa = empresa;
       // this.image_trab = image_trab;
        this.puesto = puesto;
        this.text_descrip = text_descrip;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.url = url;
        this.persona = persona;
        
       
    }
   
    
   
    //Recibe la relacion 1-n 
    @ManyToOne
    private Persona persona;
    
    
    
    
}
