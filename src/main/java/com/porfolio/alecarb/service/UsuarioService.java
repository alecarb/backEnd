
package com.porfolio.alecarb.service;

import com.porfolio.alecarb.entity.Usuario;
import com.porfolio.alecarb.repository.IUsuarioRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional  // método o bloque de código debe ejecutarse dentro de una transacción, 
//lo que significa que todas las operaciones realizadas dentro del método o bloque se considerarán 
//parte de una única transacción y se realizarán de manera atómica. 
//Esto es útil para garantizar la consistencia de los datos y evitar errores en operaciones 
//que involucren varias operaciones de base de datos. 
public class UsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;
    
    public List<Usuario> list(){
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }
    
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    
    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }
    
    
}
