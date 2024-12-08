package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller;

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
public class SellerPK implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cnpj;

    private String email;

    public SellerPK() {}

    public SellerPK(long id, String email, String cnpj) {
        this.id = id;
        this.email = email;
        this.cnpj = cnpj;
    }
}
