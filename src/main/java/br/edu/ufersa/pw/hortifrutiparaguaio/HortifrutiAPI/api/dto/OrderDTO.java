package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private Long idCard;
    private Long idClient;
    private String status;
    private Date orderDate;
}
