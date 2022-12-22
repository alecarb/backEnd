
package com.porfolio.alecarb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image_est")
    private String image_est;
    @Column(name = "institucion")
    private String institucion;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha_inicio")
    private String fecha_inicio;
    @Column(name = "Fecha_fin")
    private String fecha_fin;
    @Column (name = "en_curso")
    private boolean en_curso;
    
    public Educacion(){
        
    }

    public Educacion(String image_est, String institucion, String titulo, String fecha_inicio, String fecha_fin, boolean en_curso) {
        
        this.image_est = image_est;
        this.institucion = institucion;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.en_curso = en_curso;
    }
    
    
    
    
    
}
