package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Table(name="orders")
@Getter
@Setter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idorder")
    private int OrderId;
    @Column(name="iduser")
    private int ProductId;
    @Column(name="orderdate")
    private Date OrderDate;
}
