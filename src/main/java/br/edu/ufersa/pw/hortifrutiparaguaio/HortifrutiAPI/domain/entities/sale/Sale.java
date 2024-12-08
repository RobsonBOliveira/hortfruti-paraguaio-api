package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.sale;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.order.Order;
import jakarta.persistence.*;
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
    private Order order;

    @Column(name = "sale_date")
    private Date saleDate;

    @Column(name = "total")
    private double total;
}
