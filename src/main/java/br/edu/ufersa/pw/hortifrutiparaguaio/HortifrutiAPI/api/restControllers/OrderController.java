package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.restControllers;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.OrderRequestDTO;
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
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/orders/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
    return new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);
    }

    @PostMapping("/orders/post")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return new ResponseEntity<>(orderService.createOrder(orderRequestDTO), HttpStatus.CREATED);
    }

}
