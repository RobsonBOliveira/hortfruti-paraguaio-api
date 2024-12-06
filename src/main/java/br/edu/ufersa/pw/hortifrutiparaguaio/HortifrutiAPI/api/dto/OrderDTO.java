package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private int orderId;
    private int productId;
    private int quantity;
    private double price;
}
