
package com.porfolio.alecarb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NavbarDto {
    
    private Long id;
    private String red;
    private String logo;
    private String nombre;

    public NavbarDto() {
    }

    public NavbarDto(Long id, String red, String logo, String nombre) {
        this.id = id;
        this.red = red;
        this.nombre = nombre;
        this.logo = logo;
    }
    
    
}
