package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private Long idSeller;
    private String name;
    private String description;
    private double price;
    private int quantity;


    public ProductDTO(Product product) {
        this.id = product.getId();
        this.idSeller = product.getIdSeller();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }

}
