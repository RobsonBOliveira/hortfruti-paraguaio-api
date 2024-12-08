package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
    private Long id;
    private String phone;
    private String email;
    private String name;
    private boolean status;

    public ClientDTO() {}

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.phone = client.getPhone();
        this.email = client.getEmail();
        this.name = client.getName();
        this.status = client.isStatus();
    }
}
