package com.tanovait.home2eye;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SSConfig extends WebSecurityConfigurerAdapter {

     @Autowired
     private AuthenticationEntryPoint authEntryPoint = null;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.csrf().disable().authorizeRequests().anyRequest().authenticated()
                 .and().httpBasic()
                 .authenticationEntryPoint(authEntryPoint);
    }

     @Autowired
    void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
         authenticationManagerBuilder.inMemoryAuthentication().withUser("test")
                 .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("test"))
                 .roles("USER");
     }
}
