
package com.porfolio.alecarb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Acerca_mi {
    
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
  
    @Column(name = "descripcion") @Lob //Un LOB es un valor muy largo que puede ser de cualquier tipo, como una cadena de texto o un archivo binario.
    private String descripcion;
    
    
    
    public Acerca_mi(){
        
    }

    public Acerca_mi(Long id, String descripcion, Persona persona) {
        this.id = id;
        this.descripcion = descripcion;
        this.persona = persona;
    }

   
   //Recibe la relacion 1-n 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id") // crea y añade la FK
    @NotNull
    private Persona persona;
    
}
