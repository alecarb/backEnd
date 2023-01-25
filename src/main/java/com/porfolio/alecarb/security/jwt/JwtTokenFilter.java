
package com.porfolio.alecarb.security.jwt;

import com.porfolio.alecarb.security.service.UserDetailsImpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
/**
 * Se ejecuta por cada peticion, comprueba que sea valido el token
 * Utiliza el provider para validar que sea valido
 * Si es valido permite acceso al recurso sino lanza una excepcion
 * @author ale
 */

public class JwtTokenFilter extends OncePerRequestFilter{
    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    
    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsImpl userDetailsServiceImpl;
    
    //El token esta formado por:
    //cabecera --> Authorization: Bearer token
    //Este metodo se ejecuta cada vez que se le haga una peticion al server

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getToken(request);
            if(token != null && jwtProvider.validateToken(token)){
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth = 
                        new UsernamePasswordAuthenticationToken(userDetails,
                                null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            logger.error("Falló el método doFilter" + e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
    //Obetenemos el token sin el Bearer + el espacio
    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");
        return null;
    }


}
