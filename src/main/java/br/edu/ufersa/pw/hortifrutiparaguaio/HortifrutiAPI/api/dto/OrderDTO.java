package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private Long idCard;
    private Long idClient;
    private String status;

}
