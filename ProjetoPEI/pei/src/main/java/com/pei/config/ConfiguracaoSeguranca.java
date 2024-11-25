package com.pei.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoSeguranca{
/* 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desativa a proteção contra CSRF, se necessário
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/cadastroUsuario", "/css/**", "/js/**").permitAll() // Permite acesso público
                                .anyRequest().authenticated() // Exige autenticação para todas as outras rotas
                )
                .formLogin(form -> form
                                .loginPage("/login") // Página personalizada de login
                                .permitAll()
                )
                .logout(logout -> logout
                                .logoutUrl("/logout")
                                .permitAll()
                );
        return http.build();
    }*/
}
