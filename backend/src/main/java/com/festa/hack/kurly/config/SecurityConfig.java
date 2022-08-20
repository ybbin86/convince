package com.festa.hack.kurly.config;

import com.festa.hack.kurly.security.JwtAuthenticationFilter;
import com.festa.hack.kurly.security.JwtTokenProvider;
import com.festa.hack.kurly.type.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS )
                .and()
                .authorizeRequests()
                //.antMatchers( "/goods" ).authenticated()
                .antMatchers( "/tag" ).authenticated()
                .antMatchers( "/category" ).authenticated()
                .antMatchers( "/admin/**" ).hasRole( Role.ADMIN.name() )
                .antMatchers( "/**" ).permitAll()
                .anyRequest().permitAll()
                .and()
                .addFilterBefore( new JwtAuthenticationFilter( jwtTokenProvider ),
                        UsernamePasswordAuthenticationFilter.class )
                .logout()
                .logoutUrl( "/logout" )
                .logoutSuccessUrl( "/login" )
                .and()
                .build();
    }

}
