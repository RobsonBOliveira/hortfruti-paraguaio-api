package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.order.Order;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.sale.Sale;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class SaleDTO {
    private Long id;
    private OrderDTO order;
    private Date date;
    private double total;

    public SaleDTO(Sale sale) {
        this.id = sale.getIdSale();
        this.order = new OrderDTO(sale.getOrder());
        this.date = sale.getSaleDate();
        this.total = sale.getTotal();
    }

}
