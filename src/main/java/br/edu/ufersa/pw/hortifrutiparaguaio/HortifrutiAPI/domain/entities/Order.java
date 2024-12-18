package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Table(name = "tb_orders")
@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private long id;

    @Column(name = "status")
    @NotEmpty(message = "O campo status não pode ser vazio!")
    private String status;

    @Column(name = "order_date")
    @NotEmpty(message = "O campo Data de pedido não pode ser vazio!")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
