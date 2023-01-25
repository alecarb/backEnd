package com.porfolio.alecarb.security.service;

import com.porfolio.alecarb.security.entity.Usuario;
import com.porfolio.alecarb.security.entity.UsuarioPrincipal;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 * Clase que concvierte la clase usuario en un UsuarioMain
 * UserDetailsService es propia de Spring Security
 * @author ale
 */
@Service
@Transactional
public class UserDetailsImpl implements UserDetailsService{
    
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }


    
}
