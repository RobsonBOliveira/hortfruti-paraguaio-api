package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;



import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.User;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserRepository usuario;
    @RequestMapping("/users")
    public List<User> getUsers() {
        return usuario.findAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return usuario.findById(userId);
    }

    @PostMapping("/users/post/")
    public User createUser(@PathVariable User user) {
        return user;
    }
}

