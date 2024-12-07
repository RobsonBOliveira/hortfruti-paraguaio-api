package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;



import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.user.User;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserRepository usuario;

    @RequestMapping("/users")
    public List<User> getUsers() {return usuario.findAll();}

    @GetMapping("/users/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return usuario.findById(userId);
    }

    @PostMapping("/users/post")
    public User createUser(@RequestBody User user) {return usuario.save(user);}

    @PutMapping("/users/put/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        updatedUser.setId(userId);
        User savedUser = usuario.save(updatedUser);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/users/delete/{idUser}")
    public void deleteUser(@PathVariable Long idUser) {usuario.deleteById(idUser);}

}
