package com.bn.demo.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // declaracao de configuracao
@EnableWebSecurity // habilita o web security
public class SecurityFilter {

    @Bean // nao sei
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(HttpMethod.GET, "/produtos").permitAll() // metodo para realizar autenticacao, neste caso e habilitado para todos os usuarios
                            .requestMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN") // metodo para realizar autenticacao, neste caso e habilitado para apenas admin
                            .requestMatchers(HttpMethod.DELETE, "/produtos/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/produtos/**").permitAll()
                            .anyRequest().authenticated()
                )
                .build();
    }

}
