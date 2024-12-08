package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart_product.CartProduct;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Table(name = "tb_cart")
@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartProduct> cartProduct;
}
