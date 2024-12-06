package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private int idProduct;
    private int idSalesman;
    private String name;
    private String description;
    private double price;

}
