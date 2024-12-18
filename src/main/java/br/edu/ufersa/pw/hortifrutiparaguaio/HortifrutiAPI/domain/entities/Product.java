package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_product")
@Getter
@Setter
@Entity
public class Product {

    @EmbeddedId
    private ProductId id;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "O campo nome produto não pode ser vazio!")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    @NotNull(message = "O campo preço não pode ser vazio!")
    private double price;

    @Column(name = "quantity", nullable = false)
    @NotNull(message = "O campo quantidade não pode ser vazio!")
    private int quantity;
}
