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
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
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
        List<OrderDTO> orders = Orderrepository.findAll().stream()
                .map(order -> new OrderDTO(order))
                .collect(Collectors.toList());
        return orders;
    }

    public OrderDTO findById(Long id) {
        Optional<Order> result = Orderrepository.findById(id);
        return result.map(OrderDTO::new).orElse(null);
    }

    public OrderDTO createOrder(final OrderRequestDTO request) {
        if (request == null) {
            throw new IllegalArgumentException("Order request cannot be null");
        }

        Optional<Client> client = clientRepository.findById(request.getClient().getId());
        if (client.isEmpty()) {
            throw new EntityNotFoundException("Client not found with ID: " + request.getClient().getId());
        }

        Order order = new Order();
        order.setStatus("Testando");
        order.setOrderDate(new Date());
        order.setClient(client.get());

        Order savedOrder = Orderrepository.save(order);


        System.out.println("Client found: " + client.get().getName());

        System.out.println("Saved Order: " + savedOrder.getId());

        //Log do id do produto
        System.out.println("ProductID ProductId found: " + request.getCartProduct().getProduct().getId().getProductId());
        System.out.println("ProductId SellerId found: " + request.getCartProduct().getProduct().getId().getSeller().getId());
        // Log da quantidade do produto
        System.out.println("Product quantity: " + request.getCartProduct().getQuantity());


        ProductId id = new ProductId(request.getCartProduct().getProduct().getId().getSeller(), request.getCartProduct().getProduct().getId().getProductId());

        Optional<Product> product = productRepository.findById(id);


        Product product1 = new Product();

        product1.setId(id);

        CartProduct cartProduct = new CartProduct();
        cartProduct.setProduct(product1);
        cartProduct.setQuantity(request.getCartProduct().getQuantity());
        cartProduct.setOrder(savedOrder);



        cartProductRepository.save(cartProduct);

        Order updatedOrder = Orderrepository.findById(savedOrder.getId())
                .orElseThrow(() -> new IllegalStateException("Failed to fetch saved order"));

        System.out.println("Updated Order: " + updatedOrder);

        return new OrderDTO(updatedOrder);
    }


    public OrderDTO deleteOrder(Long id) {
        Optional<Order> result = Orderrepository.findById(id);
        Order order = result.get();
        Orderrepository.delete(order);
        return new OrderDTO(order);
    }
}
