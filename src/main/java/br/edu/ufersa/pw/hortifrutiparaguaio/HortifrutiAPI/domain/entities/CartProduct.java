package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_cart_products")
@Getter
@Setter
@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false)
    @NotNull(message = "O pedido associado não pode ser nulo!")
    private Order order;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_product", referencedColumnName = "id_product", nullable = false),
            @JoinColumn(name = "id_seller", referencedColumnName = "id_seller", nullable = false)
    })
    @NotNull(message = "O produto associado não pode ser nulo!")
    private Product product;

    @Column(name = "quantity", nullable = false)
    @NotNull(message = "O campo quantidade não pode ser nulo!")
    @Min(value = 1, message = "A quantidade deve ser no mínimo 1.")
    private Long quantity;
}
