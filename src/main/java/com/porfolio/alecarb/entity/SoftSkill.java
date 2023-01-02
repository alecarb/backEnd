
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
public class SoftSkill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "habilidad")
    private String habilidad;
    @Column (name = "porcentaje")
    private int porcentaje;
    

    public SoftSkill() {
    }

   

    public SoftSkill(String habilidad, int porcentaje) {
      
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
       
    }
    
    
    //Recibe la relacion 1-n 
    @ManyToOne
    private Persona persona;
}
