
package com.porfolio.alecarb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Navbar {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "github")
    private String github;
    @Column(name = "instagram")
    private String instagram;
    @Column(name = "linkedin")
    private String linkedin;
    @Column(name = "logo")
    private String logo;

    public Navbar() {
    }

    public Navbar(Long id, String github, String instagram, String linkedin, String logo, Persona persona) {
        this.id = id;
        this.github = github;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.logo = logo;
        this.persona = persona;
    }
    
    //Recibe la relacion 1-n 
    @ManyToOne
    private Persona persona;
    
}
