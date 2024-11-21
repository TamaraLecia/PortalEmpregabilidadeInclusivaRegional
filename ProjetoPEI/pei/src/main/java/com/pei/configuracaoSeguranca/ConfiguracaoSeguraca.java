package com.pei.configuracaoSeguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pei.service.PessoaUserDetailsService;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguraca extends WebSecurityConfigurerAdapter {

    @Autowired // inserindo dependencia
    private PessoaUserDetailsService pessoaUserDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
        .antMatchers("/imagensDoSistema/**").permitAll()
        .antMatchers("/css/**").permitAll()
        .antMatchers("/html/**").permitAll()
        .anyRequest().authenticated();

        http.formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/home").permitAll();
    }

    @Override
    //Onde é realizada a autenticação após o usuario enviar o email
    protected void configure(AuthenticationManagerBuilder autenticar) throws Exception{
        autenticar.userDetailsService(pessoaUserDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder());
    }
}
