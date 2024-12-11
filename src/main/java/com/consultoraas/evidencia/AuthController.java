package com.consultoraas.evidencia;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        return usuarioService.login(usuario);
    }

    @PostMapping("/register")
    public String register(@RequestBody Usuario usuario) {
        return usuarioService.register(usuario);
    }
}
