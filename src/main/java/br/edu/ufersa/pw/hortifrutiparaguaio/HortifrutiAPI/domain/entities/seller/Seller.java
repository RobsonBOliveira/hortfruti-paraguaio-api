package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tb_seller")
@Getter
@Setter
@Entity
public class Seller{
    @EmbeddedId
    SellerPK id;

    private String name;

    private String password;

    private boolean status;
}
