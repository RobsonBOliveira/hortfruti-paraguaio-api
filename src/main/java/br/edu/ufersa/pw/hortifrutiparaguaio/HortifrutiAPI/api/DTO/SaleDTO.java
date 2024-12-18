package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.DTO;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Sale;
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
