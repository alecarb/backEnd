
package com.porfolio.alecarb.security.entity;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/*

    Clase Encargada de generar la seguridad
    Clase que implementa los privilegios de cada usuario
    UserDetails es una clase propia de Spring Security
*/

public class UsuarioPrincipal implements UserDetails{
    
    private String nombre;
    private String nombreUsario;
    private String email;
    private String password;
    
    //Variable que nos da la autorizacion  (no confundir con autenticacion)
    // Coleccion de tipo generico que extiende
    //de GranthedAutority de Spring security
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String nombre, String nombreUsario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsario = nombreUsario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

 //Metodo que construye los privilegios (autorizacion)
    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =usuario.getRoles()
                .stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                .collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(),
                usuario.getPassword(), authorities);
    }

    //@Override los que tengan esta anotacion 
    //son metodos de UserDetails de SpringSecurity
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }
    

    @Override
    public String getUsername() {
        return nombreUsario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
            return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
        
    public String getNombre(){
        return nombre;
    }
   
    
    public String getEmail() {
        return email;
    }


    
}
