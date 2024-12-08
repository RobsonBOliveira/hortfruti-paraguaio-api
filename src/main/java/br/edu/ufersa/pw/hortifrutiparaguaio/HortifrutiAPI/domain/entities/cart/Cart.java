package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart;

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
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "tb_cart", cascade = CascadeType.ALL)
    private Set<Cart> carts;


}