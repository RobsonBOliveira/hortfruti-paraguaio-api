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
    private OrderRepository orderRepository;

    @RequestMapping("/orders")
    public List<Order> getOrders() {return orderRepository.findAll();}

    @GetMapping("/orders/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {return orderRepository.findById(id);}

    @DeleteMapping("/orders/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {orderRepository.deleteById(id);}

    @PostMapping("/orders/post")
    public Order createOrder(@RequestBody Order order) {return orderRepository.save(order);}

}
