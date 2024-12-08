package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.order.Order;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/orders/post")
    public Order createOrder(@RequestBody Order orders) {return order.save(orders);}

    @DeleteMapping("/orders/delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId){order.deleteById(orderId);}

}
