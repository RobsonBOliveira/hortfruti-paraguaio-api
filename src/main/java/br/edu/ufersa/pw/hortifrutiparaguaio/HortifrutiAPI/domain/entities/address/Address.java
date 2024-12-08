package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.address;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client.Client;
import jakarta.persistence.*;

@Table(name = "tb_address")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    private Client idCliente;

    private String street;

    private String city;

    private String state;

    @Column(name = "num")
    private long number;

    @Column(name = "zip_code")
    private String zipcode;

}