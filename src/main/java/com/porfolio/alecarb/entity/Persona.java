
package com.porfolio.alecarb.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Persona {
    
    @Id 
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
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
    @Column(name = "image_perfil")
    private String image_perfil;
    
    public Persona(){     
    }
    
    public Persona(Integer id, String nombre, String apellido, String telefono, String email, String residencia, int dni, String image_perfil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.residencia = residencia;
        this.dni= dni;
        this.image_perfil = image_perfil;
    }    
    //Estabelce la relacion 1-n entre persona 
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)    
    private List<Trabajo> trabajos;
    
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)    
    private List<Educacion> educaciones;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)    
    private List<Acerca_mi> acerca_mis;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)    
    private List<HardSkill> hardSkills;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)    
    private List<SoftSkill> softSkills;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY) 
    private List<Proyecto> proyectos;
    
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Navbar> navbars;

}
