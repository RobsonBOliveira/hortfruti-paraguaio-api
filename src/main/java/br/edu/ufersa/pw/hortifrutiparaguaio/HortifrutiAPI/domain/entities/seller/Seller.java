package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_seller")
@Getter
@Setter
@Entity
@IdClass(SellerPK.class)
public class Seller{
    @Id
    private long id;

    @Id
    private String cnpj;

    @Id
    private String email;


    private String name;


    private String password;


    private boolean status;
}
