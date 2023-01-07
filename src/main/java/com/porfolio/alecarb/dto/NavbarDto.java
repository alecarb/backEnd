
package com.porfolio.alecarb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NavbarDto {
    
    private String github;  
    private String instagram;   
    private String linkedin;   
    private String logo;

    public NavbarDto() {
    }

    public NavbarDto(String github, String instagram, String linkedin, String logo) {
        this.github = github;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.logo = logo;
    }
    
    
}
