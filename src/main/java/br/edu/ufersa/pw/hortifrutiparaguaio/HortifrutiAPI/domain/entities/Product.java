package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
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
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
