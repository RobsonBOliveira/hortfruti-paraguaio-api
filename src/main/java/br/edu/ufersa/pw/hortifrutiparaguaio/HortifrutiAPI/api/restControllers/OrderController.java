package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.order.Order;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    @Autowired
    OrderRepository order;

    @RequestMapping("/orders")
    public List<Order> getOrders(){return order.findAll();}

    @GetMapping("/orders/{orderId}")
    public Optional<Order> getOrderById(@PathVariable Long orderId){return order.findById(orderId);}

}
