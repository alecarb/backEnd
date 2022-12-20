package com.porfolio.alecarb.controller;

import com.porfolio.alecarb.dto.UsuarioDto;
import com.porfolio.alecarb.entity.Usuario;
import com.porfolio.alecarb.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
//@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlller {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("ver/usuarios") //trae en esa ruta
    @ResponseBody //la respuesta del cuerpo
    public List<Usuario> verUsuarios() { //creo el metodo del controlador
        return usuarioService.list(); //aca llamo al metodo del servicio
    }
    
    @GetMapping("ver/{id}")
    @ResponseBody
    public Optional<Usuario> findById(Long id){ //Optional es la mejor para buscar
       return usuarioService.findById(id);
        
    }
    
    @PostMapping("new/usuario") //llevo a esa ruta
    public void save(@RequestBody Usuario nuevUsuario) { //nombre del metodo y el request que le paso en Json desde Postman
        usuarioService.save(nuevUsuario); //traigo el metodo del servicio
    }

    @DeleteMapping("delete/{id}")
    public void deleteUsuarioByid(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }

    @PutMapping("usuario/editar/{id}")
    @ResponseBody
    public ResponseEntity<?> editUsuario(@PathVariable("id") Long id,@RequestBody UsuarioDto usuarioDto){ 
        try {
            Usuario usuario = usuarioService.findById(id).get(); //buscamos el usuario 
            usuario.setNombre(usuarioDto.getNombre()); //traemos el nombre desde el DTO y lo seteo
            usuario.setApellido(usuarioDto.getApellido()); //traigo el apellodo del DTO Y lo seteo
            usuario.setEmail(usuarioDto.getEmail());
            usuario.setResidencia(usuarioDto.getResidencia());
            usuario.setDni(usuarioDto.getDni());
            usuario.setTelefono(usuarioDto.getTelefono());
            
            usuarioService.save(usuario); //guardamos los cambios.
            return new ResponseEntity<Usuario>(HttpStatus.OK); // se retorna una respuesta con status 201
            
        } catch (Exception e) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND); //se retorna una respuesta 404
        }
            
            

        
}


}
