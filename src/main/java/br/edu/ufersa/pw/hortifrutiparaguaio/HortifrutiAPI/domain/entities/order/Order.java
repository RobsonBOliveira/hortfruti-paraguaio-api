package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.order;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart.Cart;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client.Client;
import jakarta.persistence.*;
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
    private long orderNum;

    @OneToOne
    @JoinColumn(name = "id_cart", referencedColumnName = "id", nullable = false)
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", nullable = false)
    private Cart cartClient;

    private String status;

    @Column(name = "order_date")
    private Date orderDate;
}
