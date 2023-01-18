
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
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "proyecto")
    private String proyecto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "image_proy")
    private String image_proy;
   

    public Proyecto() {
    }
    
   

    public Proyecto(String proyecto) {
       
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.image_proy = image_proy;
        
      
    }
    
    
    //Recibe la relacion 1-n 
    @ManyToOne
    private Persona persona;
    
}
