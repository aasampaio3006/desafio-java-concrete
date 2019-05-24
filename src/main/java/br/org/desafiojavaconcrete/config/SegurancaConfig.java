/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.desafiojavaconcrete.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 *
 * @author Andrade.Sampaio
 */
@Configuration
@EnableWebSecurity
public class SegurancaConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("asampaio").password("123456").roles("ADMIN");        
    }
    
    @Override
    protected  void configure(HttpSecurity http)throws Exception{
        //aplicar a seguranca na aplicação/ qualquer requisição tem se autenticação
        //deixando a aplicação em  Stateless
        //liberando swagger
        http.authorizeRequests()
               // .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**")
              //  .permitAll()   
             .anyRequest().authenticated()
                .and()
             .httpBasic()
             .and()
             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and().csrf().disable();
        
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        //nao irar codificar o password
        return NoOpPasswordEncoder.getInstance();
    }
    
}
