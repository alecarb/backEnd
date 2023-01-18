
package com.porfolio.alecarb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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

   

    public SoftSkill(String habilidad, int porcentaje, Persona persona) {
        this.persona = persona;
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
       
    }
    
    
    //Recibe la relacion 1-n 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id") // crea y añade la FK
    @NotNull
    private Persona persona;
}
