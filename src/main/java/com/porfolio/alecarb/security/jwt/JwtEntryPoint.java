
package com.porfolio.alecarb.security.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{
    //Se implementa un logger para ver cual metodo da error en cado de falla
        private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    //Metodo implementado de AuthenticationEntryPoint
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response, 
                         AuthenticationException authException) throws IOException, ServletException {
       logger.error("Falló el método commence");
       response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No esta autorizado");
    }

}
