package br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.service;

import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.CartProductDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.api.dto.SaleDTO;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Order;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.entities.Sale;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.CartProductRepository;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.OrderRepository;
import br.edu.ufersa.pw.hortifrutiparaguaio.HortifrutiAPI.domain.repositories.SaleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {


    private final SaleRepository saleRepository;
    private final OrderRepository orderRepository;
    private final CartProductRepository cartProductRepository;

    public SaleService(SaleRepository saleRepository, OrderRepository orderRepository, CartProductRepository cartProductRepository) {
        this.saleRepository = saleRepository;
        this.orderRepository = orderRepository;
        this.cartProductRepository = cartProductRepository;
    }

    public ResponseEntity<?> saveSale(Sale sale) {
        try {

            Optional<Order> updateOrder = orderRepository.findById(sale.getOrder().getId());
            List<CartProductDTO> cartProducts = new CartProductDTO()
                    .listCartProducts(cartProductRepository.findByOrderId(updateOrder.get().getId()));

            double total = 0;

            for (CartProductDTO cart : cartProducts) {
                System.out.println(cart.getProduct().getName());
                total += cart.getProduct().getPrice() * cart.getQuantity();
            }

            sale.setTotal(total);
            sale.setSaleDate(new Date());
            sale.setOrder(updateOrder.get());

            updateOrder.get().setStatus("APPROVED");
            orderRepository.save(updateOrder.get());
            saleRepository.saveAndFlush(sale);
            orderRepository.flush();
            return ResponseEntity.ok(new SaleDTO(sale));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to save sale: " + e.getMessage());
        }
    }


    public Optional<Sale> getSaleById(Long id) {
        return saleRepository.findById(id);
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

}
