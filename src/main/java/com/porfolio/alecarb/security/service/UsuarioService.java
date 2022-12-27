package com.porfolio.alecarb.security.service;

import com.porfolio.alecarb.security.entity.Usuario;
import com.porfolio.alecarb.security.repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    IUsuarioRepository iUsuarioRepository;
    
    public Optional<Usuario> getNombreUsuario(String nombreUsuario) {
        return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    //chek si existe usuario
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

//chek si existe usuario 
    public boolean existsByEmail(String email) {
        return iUsuarioRepository.existsByEmail(email);
    }

//guarda un usuario nuevo
    public void save(Usuario usuario) {
        iUsuarioRepository.save(usuario);
        
    }
    
}
