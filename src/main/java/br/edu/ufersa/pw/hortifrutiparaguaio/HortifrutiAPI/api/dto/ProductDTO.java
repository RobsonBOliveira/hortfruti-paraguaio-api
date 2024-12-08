package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private int id;
    private int idSalesman;
    private String name;
    private String description;
    private double price;
    private int quantity;
}
