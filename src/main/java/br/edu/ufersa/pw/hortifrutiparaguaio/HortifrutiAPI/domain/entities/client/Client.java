package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_client")
@Getter
@Setter
@Entity
public class Client {
    @EmbeddedId
    private ClientPK id;

    private String name;

    private String password;

    private boolean status;
}
