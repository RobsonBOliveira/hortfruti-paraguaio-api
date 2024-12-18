package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class ProductId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_seller", nullable = false)
    @NotEmpty(message = "O campo id vendedor não pode ser vazio!")
    private Seller seller;

    @Column(name = "id_product", nullable = false)
    @NotEmpty(message = "O campo id produto não pode ser vazio!")
    private Long productId;

    public ProductId() {}

    public ProductId(Long productId) {
        this.productId = productId;
    }

    public ProductId(Seller seller, Long productId) {
        this.seller = seller;
        this.productId = productId;
    }
}
