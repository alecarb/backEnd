
package com.porfolio.alecarb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Acerca_mi {
    
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "image_perfil")
    private String image_perfil;
    
    public void Acerca_mi(){
        
    }

    public Acerca_mi(String descripcion, String image_perfil) {

        this.descripcion = descripcion;
        this.image_perfil = image_perfil;
    }
    
    
    
}
