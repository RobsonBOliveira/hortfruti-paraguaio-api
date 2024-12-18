package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "O campo número de pedido não pode ser vazio!")
    private Order order;

    @Column(name = "sale_date")
    @NotEmpty(message = "O campo data de venda não pode ser vazio!")
    private Date saleDate;

    @Column(name = "total")
    @NotEmpty(message = "O campo total não pode ser vazio!")
    private double total;
}
