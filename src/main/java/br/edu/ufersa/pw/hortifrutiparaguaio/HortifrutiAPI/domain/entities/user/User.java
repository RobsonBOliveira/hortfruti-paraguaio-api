package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.user;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Table(name = "users")
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false , length = 100)
    private String nome;
    @Column(name = "email", nullable = false , length = 100)
    private String email;
    @Column(name = "password", nullable = false , length = 100)
    private String senha;
}
