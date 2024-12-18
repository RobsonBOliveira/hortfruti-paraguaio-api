package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Table(name = "tb_sale")
@Getter
@Setter
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale")
    private Long idSale;

    @OneToOne
    @JoinColumn(name = "num_order", referencedColumnName = "num", nullable = false)
    @NotNull(message = "O campo número de pedido não pode ser nulo!")
    private Order order;

    @Column(name = "sale_date")
    @NotNull(message = "O campo data de venda não pode ser nulo!")
    private Date saleDate;

    @Column(name = "total")
    @NotNull(message = "O campo total não pode ser nulo!")
    private double total;
}
