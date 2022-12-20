package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigV2 {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                /*.antMatchers(HttpMethod.GET, "/parking-spot/**").permitAll() Não estamos usando isto, pois definimos o controle de acesso
                .antMatchers(HttpMethod.POST, "/parking-spot").hasAnyRole("USER", "ADMIN") no controller, ao fazer isso tive que usar
                .antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN") a anotação @EnableGlobalMethodSecurity(prePostEnabled = true) */
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
