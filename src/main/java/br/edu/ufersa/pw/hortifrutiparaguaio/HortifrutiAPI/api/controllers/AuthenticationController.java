package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.controllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.DTO.AuthenticationUserDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.DTO.RegisterUserDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Client;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final ClientService clientService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    ClientService clientService,
                                    PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.clientService = clientService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthenticationUserDTO data) {
        try {
            var authRequest = new UsernamePasswordAuthenticationToken(data.email(), data.password());

            this.authenticationManager.authenticate(authRequest);

            // Retorna uma mensagem de sucesso
            return ResponseEntity.ok(Map.of(
                    "message", "Login successful",
                    "email", data.email()
            ));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "message", "Invalid email or password"
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "message", "An unexpected error occurred",
                    "error", e.getMessage()
            ));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDTO data) {
        try {
            // Verifica se o email já está cadastrado
            if (this.clientService.findByEmail(data.email()) != null) {
                return ResponseEntity.badRequest().body(Map.of(
                        "message", "Email already registered"
                ));
            }

            Client newClient = new Client();
            newClient.setEmail(data.email());
            newClient.setPhone(data.phone());
            newClient.setPassword(passwordEncoder.encode(data.password()));
            newClient.setName(data.name());
            System.out.println(data.role());
            newClient.setRole(data.role());

            clientService.createClient(newClient);

            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "message", "User registered successfully",
                    "email", newClient.getEmail()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "message", "An unexpected error occurred",
                    "error", e.getMessage()
            ));
        }
    }
}
