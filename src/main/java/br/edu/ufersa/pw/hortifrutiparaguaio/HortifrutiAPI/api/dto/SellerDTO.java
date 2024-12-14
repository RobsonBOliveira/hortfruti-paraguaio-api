package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.seller.Seller;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerDTO {
    private Long id;
    private String cnpj;
    private String email;
    private String name;
    private boolean status;

    public SellerDTO(Seller seller) {
        this.id = seller.getId();
        this.cnpj = seller.getCnpj();
        this.email = seller.getEmail();
        this.name = seller.getName();
        this.status = seller.isStatus();
    }
}
