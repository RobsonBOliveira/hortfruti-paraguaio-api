package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private long id;
    private String email;
    private String name;
}
