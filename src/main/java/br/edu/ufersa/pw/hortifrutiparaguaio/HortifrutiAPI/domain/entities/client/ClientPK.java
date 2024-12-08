package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class ClientPK implements Serializable {
    private long id;
    private String phoneNumber;
    private String email;
}
