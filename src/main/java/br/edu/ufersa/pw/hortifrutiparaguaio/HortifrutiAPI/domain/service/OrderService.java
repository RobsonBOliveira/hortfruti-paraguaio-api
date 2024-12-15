package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.*;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.cart_product.CartProduct;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.client.Client;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.order.Order;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product.Product;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.product.ProductId;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.CartProductRepository;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.ClientRepository;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.OrderRepository;


import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository Orderrepository;
    private final CartProductRepository cartProductRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository Orderrepository, CartProductRepository cartProductRepository,
                        ClientRepository clientRepository, ProductRepository productRepository) {
        this.Orderrepository = Orderrepository;
        this.cartProductRepository = cartProductRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    public List<OrderDTO> findAll() {
        List<Order> orders = Orderrepository.findAll();
        return orders.stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

    public OrderDTO findById(Long id) {
        Optional<Order> result = Orderrepository.findById(id);
        return result.map(OrderDTO::new).orElse(null);
    }

    @Transactional
    public ResponseEntity<?> createOrder(final OrderRequestDTO request) {
        if (request == null) {
            throw new IllegalArgumentException("Order request cannot be null");
        }

        Optional<Client> client = clientRepository.findById(request.getClient().getId());
        if (client.isEmpty()) {
            throw new EntityNotFoundException("Client not found with ID: " + request.getClient().getId());
        }

        Order order = new Order();
        order.setStatus("Só vendo");
        order.setOrderDate(new Date());
        order.setClient(client.get());

        Order savedOrder = Orderrepository.save(order);

        for (CartProduct cartProduct : request.getCartProducts()) {
            ProductId id = new ProductId(
                    cartProduct.getProduct().getId().getSeller(),
                    cartProduct.getProduct().getId().getProductId()
            );
            Optional<Product> productOpt = productRepository.findById(id);
            if (productOpt.isEmpty()) {
                throw new EntityNotFoundException("Product not found with ID: " + id);
            }
            Product product = productOpt.get();
            CartProduct newCartProduct = new CartProduct();
            newCartProduct.setProduct(product);
            newCartProduct.setQuantity(cartProduct.getQuantity());
            newCartProduct.setOrder(savedOrder);
            cartProductRepository.save(newCartProduct);
            cartProductRepository.flush();
        }
        return ResponseEntity.ok(new OrderDTO(savedOrder));
    }


    public OrderDTO deleteOrder(Long id) {
        Order order = Orderrepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
        Orderrepository.delete(order);
        return new OrderDTO(order);
    }
}
