package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_client")
@Getter
@Setter
@Entity
@IdClass(ClientPK.class)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Id
    @Column(name = "phone_number")
    private String phoneNumber;

    @Id
    private String email;

    private String password;

    private boolean status;
}
