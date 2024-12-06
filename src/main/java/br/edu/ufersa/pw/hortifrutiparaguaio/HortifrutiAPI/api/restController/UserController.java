package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restController;



import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Usuario;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UsuarioRepository usuario;
    @RequestMapping("/users")
    public List<Usuario> getUsers() {
        return (List<Usuario>) usuario.findAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<Usuario> getUserById(@PathVariable Long userId) {
        return usuario.findById(userId);
    }

    @PostMapping("/users/post/")
    public Usuario createUser(@PathVariable Usuario usuario) {
        return  usuario;
    }
}

