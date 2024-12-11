package com.consultoraas.evidencia.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Deshabilitar protección CSRF para simplicidad
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/auth/register", "/auth/login").permitAll() // Rutas públicas
                .anyRequest().authenticated()) // Cualquier otra ruta requiere autenticación
            .httpBasic(withDefaults()); // Autenticación básica

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Encriptación para contraseñas
    }
}
