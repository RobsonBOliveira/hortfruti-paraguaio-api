package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class SellerPK implements Serializable {
    private long id;
    private String cnpj;
    private String email;
    private String name;
    private String password;
    private boolean status;
}
