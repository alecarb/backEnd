
package com.porfolio.alecarb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NavbarDto {
    
    private String facebook;  
    private String instagram;   
    private String linkedin;   
    private String logo;

    public NavbarDto() {
    }

    public NavbarDto(String facebook, String instagram, String linkedin, String logo) {
        this.facebook = facebook;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.logo = logo;
    }
    
    
}
