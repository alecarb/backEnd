
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
public class Trabajo {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "empresa")
    private  String empresa;
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
   
    
    

    @ManyToOne(cascade = CascadeType.ALL) //recibe la relacion n-1
    @JoinColumn(name = "persona_id") // crea y añade la FK  
    @NotNull
    private Persona persona;

    public Trabajo() {
    }

    public Trabajo(Integer id, String empresa , String puesto, String text_descrip, String fecha_inicio, String fecha_fin, String url, Persona persona) {
        this.id = id;
        this.empresa = empresa;      
        this.puesto = puesto;
        this.text_descrip = text_descrip;
        this.fecha_inicio = fecha_inicio;
        
        this.fecha_fin = fecha_fin;
        this.url = url;
       
       
        
       
    }
   
        
    
}
