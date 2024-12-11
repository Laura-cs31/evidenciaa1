package com.consultoraas.evidencia;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public String login(Usuario usuario) {
        // Simulación de autenticación
        if ("admin".equals(usuario.getUsername()) && "password".equals(usuario.getPassword())) {
            return "Login exitoso";
        }
        return "Credenciales incorrectas";
    }

    public String register(Usuario usuario) {
        // Simulación de registro (en una base de datos real, guardaríamos el usuario)
        return "Usuario registrado con éxito: " + usuario.getUsername();
    }
}
