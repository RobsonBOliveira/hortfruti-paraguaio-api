package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name="orders")
@Getter
@Setter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idorder")
    private int OrderId;
    @Column(name="idproduct")
    private int ProductId;
    @Column(name="quantity")
    private int Quantity;
    @Column(name="price")
    private double Price;
}
