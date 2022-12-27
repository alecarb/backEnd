
package com.porfolio.alecarb.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonaDto implements Serializable{
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String residencia;
    private int dni;
    
    public PersonaDto(){
        
    }

    public PersonaDto(String nombre, String apellido, String email, String telefono, String residencia, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.residencia = residencia;
        this.dni = dni;
    }

    
    
    
}
