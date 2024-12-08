package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerDTO {
    private Long id;
    private String cnpj;
    private boolean status;
}
