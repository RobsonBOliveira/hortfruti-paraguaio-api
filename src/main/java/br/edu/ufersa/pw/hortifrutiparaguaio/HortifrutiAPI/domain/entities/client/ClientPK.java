package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ClientPK implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phone_number;

    private String email;

    public ClientPK() {}

    public ClientPK(long id, String phone_number, String email) {
        this.id = id;
        this.phone_number = phone_number;
        this.email = email;
    }
}
