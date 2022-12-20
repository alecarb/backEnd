
package com.porfolio.alecarb.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Usuario {
    
    @Id 
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String  nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "residencia")
    private String residencia;
    @Column (name = "dni")
    private int dni;
    
    
    
    public Usuario(){
        
    }
    
    public Usuario(String nombre, String apellido, String telefono, String email, String residencia, int dni) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.residencia = residencia;
        this.dni= dni;
    }
    
    
            
    
    
}
