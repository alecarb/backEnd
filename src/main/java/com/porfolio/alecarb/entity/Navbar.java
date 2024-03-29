
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

@Entity @Getter @Setter
public class Navbar {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "red")
    private String red;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "logo")
    private String logo;

    public Navbar() {
    }

    public Navbar(Integer id, String red, Persona persona, String nombre, String logo) {
        this.id = id;
        this.red= red;
        this.persona = persona;
        this.nombre = nombre;
        this.logo = logo;
    }
    
    //Recibe la relacion 1-n 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id") // crea y añade la FK
  
    private Persona persona;
    
}
