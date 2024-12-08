package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
    private Long id;
    private String phone;
    private String email;
    private String name;
    private String password;
    private boolean status;

}
