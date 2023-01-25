
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
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "proyecto")
    private String proyecto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "image_proy")
    private String image_proy;
   

    public Proyecto() {
    }
    
   

    public Proyecto(Integer id, String proyecto, String descripcion, String image_proy, Persona persona) {
        this.id = id;
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.image_proy = image_proy;
        this.persona = persona;
        
      
    }
    
    
   //Recibe la relacion 1-n 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id") // crea y añade la FK
    @NotNull
    private Persona persona;
    
}
