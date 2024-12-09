package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.order.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private Long idCard;
    private Long idClient;
    private String status;


    public OrderDTO(Order order) {
        this.id = order.getId();
        this.idCard = order.getCart().getId();
        this.idClient = order.getCart().getClient().getId();
        this.status = order.getStatus();
    }
}
