package com.porfolio.alecarb.security;

import com.porfolio.alecarb.security.jwt.JwtEntryPoint;
import com.porfolio.alecarb.security.jwt.JwtTokenFilter;
import com.porfolio.alecarb.security.service.UserDetailsImpl;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
//con prePostEnabled se para indicar a que metodos puede acceder solo el admin
//Los metodos que no lleven anotacion pueden acceder el admin como un genereic user
//@preauthorized solo puede acceder el admin
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class MainSecurity implements WebMvcConfigurer {

    @Autowired
    UserDetailsImpl userDetailsImplements;

    //Devuelve el mensaje de no autorizado
    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    /**
     * Encripta el pasword
     *
     * @return password encriptado
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.cors().configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
            config.setAllowedOrigins(Arrays.asList("https://alecarbargprog.web.app"));
            config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
            return config;
        });
        /*  
    http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
           .and().cors().configurationSource(request -> {
             CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
             config.setAllowedOrigins(Arrays.asList("http://localhost:8080", "https://alecarbargprog.onrender.com"));
             config.setAllowedMethods(Collections.singletonList("*"));
             return config;
    });
         */
        return http.build();
    }

    /*
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**");
            
    

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cc = new CorsConfiguration();
        cc.setAllowedHeaders(Arrays.asList
        ("Origin,Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization"));
        cc.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        cc.setAllowedOrigins(Arrays.asList("/*"));
        //cc.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT", "PATCH"));
        cc.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        cc.addAllowedOrigin("*");
        cc.setMaxAge(Duration.ZERO);
        cc.setAllowCredentials(Boolean.FALSE);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cc);
        return source;
    }
     */
}
