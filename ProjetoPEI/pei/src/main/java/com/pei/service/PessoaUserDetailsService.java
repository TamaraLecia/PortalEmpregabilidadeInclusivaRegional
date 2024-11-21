package com.pei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pei.models.Pessoa;
import com.pei.models.PessoaUserDetailsImplementacao;
import com.pei.repository.PessoaRepository;

@Service
public class PessoaUserDetailsService implements UserDetailsService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pessoa pessoa = pessoaRepository.findBYEmail(email)
        //Excessão para converter o metodo optional da classe repository para o tipo pessoa
        .orElseThrow( () -> new UsernameNotFoundException("Usuario não encontrado"));
        return new PessoaUserDetailsImplementacao(pessoa);
    }

}
