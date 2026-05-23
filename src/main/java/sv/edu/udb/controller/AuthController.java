package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import sv.edu.udb.domain.Usuario;
import sv.edu.udb.dto.AuthRequest;
import sv.edu.udb.dto.AuthResponse;
import sv.edu.udb.repository.UsuarioRepository;
import sv.edu.udb.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // LOGIN
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        // 🔥 TRAER USUARIO DESDE BD
        Usuario usuario = usuarioRepository
                .findByUsername(request.getUsername())
                .orElseThrow();

        // 🔥 GENERAR TOKEN
        String token = jwtService.generateToken(request.getUsername());

        // 🔥 DEVOLVER TOKEN + ROL
        return new AuthResponse(
                token,
                usuario.getRol()
        );
    }

    // REGISTRO
    @PostMapping("/register")
    public Usuario register(@RequestBody Usuario usuario) {

        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword())
        );

        usuario.setRol("USER"); // siempre USER

        return usuarioRepository.save(usuario);
    }
}