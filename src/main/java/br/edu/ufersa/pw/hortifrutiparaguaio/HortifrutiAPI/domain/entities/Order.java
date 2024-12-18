package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @Column(name = "status", nullable = false)
    @NotEmpty(message = "O campo status não pode ser vazio!")
    private String status;

    @Column(name = "order_date", nullable = false)
    @NotNull(message = "O campo Data de pedido não pode ser vazio!")
    @PastOrPresent(message = "A data do pedido não pode ser no futuro!")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @NotNull(message = "O cliente associado ao pedido não pode ser nulo!")
    private Client client;
}
