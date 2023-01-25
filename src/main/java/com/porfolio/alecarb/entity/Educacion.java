
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
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @Column(name = "institucion")
    private String institucion;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha_inicio")
    private String fecha_inicio;
    @Column(name = "Fecha_fin")
    private String fecha_fin;
    
    
    
    public Educacion(){
        
    }

    public Educacion( String institucion, String titulo, String fecha_inicio, String fecha_fin, Persona persona) {
        
       
        this.persona = persona;
        this.institucion = institucion;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        
       
    }
    
    //Recibe la relacion 1-n 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id") // crea y añade la FK
    @NotNull
    private Persona persona;
    
    
    
}
