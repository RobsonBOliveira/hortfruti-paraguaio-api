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
    OrderRepository orderRepository;

    @RequestMapping("/orders")
    public List<Order> getOrders() {return orderRepository.findAll();}

    @GetMapping("/orders/{orderId}")
    public Optional<Order> getOrderById(@PathVariable Long orderId) {return orderRepository.findById(orderId);}

    @PostMapping("/orders/post")
    public Order createOrder(@RequestBody Order order) {return orderRepository.save(order);}

    @DeleteMapping("/orders/delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderRepository.deleteById(orderId);
    }

}
