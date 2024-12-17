package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private ClientDTO client;
    private String status;
    private Date date;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.client = new ClientDTO(order.getClient());
        this.status = order.getStatus();
        this.date = order.getOrderDate();
    }
}
