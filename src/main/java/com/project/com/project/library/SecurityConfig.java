package com.project.com.project.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests() // Allow public access to specific paths
//                        .anyRequest().authenticated();              // Restrict access to other paths

        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF protection in Spring Security 6.1
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/public/**").permitAll()  // Publicly accessible paths
                        .anyRequest().authenticated()              // All other paths require authentication
                )
                .httpBasic(basic -> {});
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);  // Use in-memory storage for simplicity
//    }
}
