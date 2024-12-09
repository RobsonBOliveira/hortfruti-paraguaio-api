package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.order.Order;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/orders")
    public ResponseEntity<?> getOrders() {
        ResponseEntity<?> response = new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
        return response;
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        ResponseEntity<?> response = new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/orders/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        ResponseEntity<?> response = new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);
    return response;
    }

    @PostMapping("/orders/post")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        ResponseEntity<?> response = new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
        return response;
    }

}
