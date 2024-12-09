package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.OrderDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.order.Order;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.OrderRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderDTO> findAll() {
        List<OrderDTO> orders = repository.findAll().stream()
                .map(order -> new OrderDTO(order))
                .collect(Collectors.toList());
        return orders;
    }

    public OrderDTO findById(Long id) {
        Optional<Order> result = repository.findById(id);
        return result.map(OrderDTO::new).orElse(null);
    }

    public OrderDTO createOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order não pode ser nulo.");
        }
        Order savedOrder = repository.save(order);
        return new OrderDTO(savedOrder);
    }

    public OrderDTO deleteOrder(Long id) {
        Optional<Order> result = repository.findById(id);
        Order order = result.get();
        repository.delete(order);
        return new OrderDTO(order);
    }
}
